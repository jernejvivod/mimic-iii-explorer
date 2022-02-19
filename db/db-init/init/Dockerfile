FROM postgres:latest

ENV POSTGRES_USER=postgres POSTGRES_PASSWORD=postgres datadir="/mimic-iii-data/"

COPY ./init-script/init.sh /docker-entrypoint-initdb.d/
COPY ./build-scripts /build-scripts

RUN apt-get update \
 && apt-get -y install make
