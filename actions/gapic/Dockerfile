FROM ubuntu:21.04

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get -qq update \
    && apt-get -qq install curl python3 python3-pip python3-distutils python-is-python3 git zip unzip

RUN curl -L https://github.com/bazelbuild/bazelisk/releases/download/v1.6.1/bazelisk-linux-amd64 -o bazel \
    && cp bazel /usr/local/bin/bazel \
    && chmod +x /usr/local/bin/bazel \
    && bazel version

RUN python --version

COPY entrypoint.sh /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
