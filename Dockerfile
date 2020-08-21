FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
WORKDIR /opt/app
ARG JAR_FILE=target/camunda-workflow-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
