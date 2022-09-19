package com.example.UdemyGrpc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class UdemyGrpcApplicationCompareGrpcVsRest {

  public static void main(String[] args) throws IOException {
    Person person = Person.newBuilder().setName("huong").setAge(25).build();


    //ProtoBuf
    // serialize
//    Path path = Paths.get("huong.ser");
//    Files.write(path, person.toByteArray());
//
//    // deserialize
//    byte[] bytes = Files.readAllBytes(path);
//    Person newPerson = Person.parseFrom(bytes);
//    System.out.println("+++++++++++++++++++++");
//    System.out.println(newPerson.getAge());
//    SpringApplication.run(UdemyGrpcApplication.class, args);


    /** compare json vs protobuf */

    // Json
    JPerson jPerson = new JPerson("Json name", 10l);
    ObjectMapper mapper = new ObjectMapper();
    Runnable json = new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        // serialize
        byte[] bytes = mapper.writeValueAsBytes(jPerson);
        //deserialize
        mapper.readValue(bytes, JPerson.class);
      }
    };

    Person protobufPerson = Person.newBuilder().setAge(10).setName("huong").build();
    Runnable protobuf = new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        byte[] bytes = protobufPerson.toByteArray();
        Person deserializePerson = Person.parseFrom(bytes);
      }
    };

    runPerformanceTest(json, "json");
    runPerformanceTest(protobuf, "protobuf");

  }

  private static void runPerformanceTest(Runnable runnable, String method){
    long time1 = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++){
      runnable.run();
    }
    long time2 = System.currentTimeMillis();
    System.out.println(method + " Time execute " + (time2 - time1));
  }
}
