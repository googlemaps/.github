FROM gcr.io/cloud-builders/bazel@sha256:7bd6d26119121e301f30366b5aafbbd0f4b3db9be5fd9da34db49df745e18e2b

RUN apt-get install zip

COPY entrypoint.sh /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]