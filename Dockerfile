FROM java:8

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
COPY pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]

# Adding source, compile and package into a fat jar
COPY src /code/src
COPY rivescript /code/rivescript


RUN ["mvn", "package"]


EXPOSE 8080
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "/code/target/ChatBot-1.0-SNAPSHOT.jar"]
