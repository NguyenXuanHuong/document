FROM openjdk:11-jdk
RUN mkdir -p /home/app
COPY . /home/app
ENTRYPOINT ["java", "-jar", "/home/app/target/AmigoMongoSpringBoot-0.0.1-SNAPSHOT.jar"]
