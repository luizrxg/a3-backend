FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/a3

COPY /target/spring-boot*.jar a3.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 9000

CMD java ${ADDITIONAL_OPTS} -jar a3.jar --spring.profiles.active=${PROFILE}