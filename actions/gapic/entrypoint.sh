#!/bin/bash -l

set -eu
set -o pipefail

TARGET_DIR=$(echo $INPUT_TARGET | sed 's/:/\//g' | sed 's/^\/*//g')
TARGET_OUTPUT="${TARGET_DIR}.tar.gz"
SLUG=$(echo $INPUT_TARGET | sed 's/^\/*//g' | sed 's/[\/.:]/_/g')
BRANCH="__gapic_action__/${SLUG}"

TEMP_GIT_GOOGLEAPIS=$(mktemp -d)
TEMP_GIT_LOCAL=$(mktemp -d)
GOOGLE_APPLICATION_CREDENTIALS=$(mktemp)

#### BUILD Target ####

pushd $TEMP_GIT_GOOGLEAPIS

git clone --single-branch --branch master https://github.com/googleapis/googleapis.git .

set +x # WARNING: do not remove
if [[ -n "${INPUT_CACHE_SERVICE_ACCOUNT}" ]]; then
    echo -n "${INPUT_CACHE_SERVICE_ACCOUNT}" >$GOOGLE_APPLICATION_CREDENTIALS
    echo "build --remote_http_cache=https://storage.googleapis.com/${INPUT_CACHE_BUCKET}" >>.bazelrc
    echo "build --google_credentials=${GOOGLE_APPLICATION_CREDENTIALS}" >>.bazelrc
fi

bazel build $INPUT_TARGET

popd

#### MAKE LOCAL CHANGES ####

pushd $TEMP_GIT_LOCAL

git clone "https://${GITHUB_ACTOR}:${INPUT_GITHUB_TOKEN}@github.com/${GITHUB_REPOSITORY}.git" .

git config --global user.email $INPUT_GIT_EMAIL
git config --global user.name $INPUT_GIT_NAME

git checkout -B $BRANCH

# reset since this may run in cron
git reset --hard origin/master

# extract the tar to the correct location
tar xf "${TEMP_GIT_GOOGLEAPIS}/bazel-bin/${TARGET_OUTPUT}" --strip-components $INPUT_TAR_STRIP_COMPONENTS $INPUT_TAR_PATH

#### PUBLISH COMMITS ####

[[ -n $(git diff "origin/master") ]] && differs_from_master=1 || differs_from_master=0

if [ $differs_from_master ]; then
    git add -A
    git commit -m 'feat: regenerate gapic'

    [[ -n $(git ls-remote --heads origin ${BRANCH}) ]] && has_branch=1 || has_branch=0
    [[ -n $(git diff "origin/${BRANCH}") ]] && differs_from_branch=1 || differs_from_branch=0

    if [[ !$has_branch || $differs_from_branch ]]; then
        git push -f -u origin $BRANCH

        curl \
            -H "Authorization: Bearer ${INPUT_GITHUB_TOKEN}" \
            -H "Content-Type:application/json" \
            -X POST https://api.github.com/repos/${GITHUB_REPOSITORY}/pulls \
            -d "{\"title\":\"GAPIC Client Update: ${INPUT_TARGET}\", \"body\": \"\", \"head\": \"$BRANCH\", \"base\": \"master\"}"
    fi

fi

popd
