FROM openjdk:11-jdk
RUN mkdir -p /home/app
COPY target/mostBasicTest-0.0.1-SNAPSHOT.jar /home/app
ENTRYPOINT ["java", "-jar", "/home/app/mostBasicTest-0.0.1-SNAPSHOT.jar"]
