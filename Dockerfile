FROM ubuntu:latest
LABEL authors="kido"

ENTRYPOINT ["top", "-b"]