FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o BiatDSI.jar "http://192.168.1.14:8081/repository/maven-releases/com/exemple/BiatDSI/1.0/BiatDSI-1.0.jar" -L
ENTRYPOINT ["java","-jar","/BiatDSI.jar"]
EXPOSE 8089


