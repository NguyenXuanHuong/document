FROM openjdk:11-jdk
RUN mkdir -p /home/app
COPY . /home/app
ENTRYPOINT ["java", "-jar", "/home/app/target/TestSQLQuery-0.0.1-SNAPSHOT.jar"]
