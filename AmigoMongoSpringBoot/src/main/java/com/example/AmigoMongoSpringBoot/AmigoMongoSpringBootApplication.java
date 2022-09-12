package com.example.AmigoMongoSpringBoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmigoMongoSpringBootApplication {


	public static void main(String[] args) {
		System.out.println("port =============== "+System.getenv("PORT"));
		SpringApplication.run(AmigoMongoSpringBootApplication.class, args);

	}

}
