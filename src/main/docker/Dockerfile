FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER BAYER
ADD iRODS-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]