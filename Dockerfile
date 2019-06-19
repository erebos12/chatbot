FROM maven:3.6.1-jdk-11-slim

WORKDIR /code

# Prepare by downloading dependencies
COPY pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]

# Adding source, compile and package into a fat jar
COPY src /code/src
COPY rivescript /code/rivescript


RUN ["mvn", "package"]


EXPOSE 8080
CMD ["/bin/bash", "-c", "java -jar /code/target/ChatBot-1.0-SNAPSHOT.jar"]
