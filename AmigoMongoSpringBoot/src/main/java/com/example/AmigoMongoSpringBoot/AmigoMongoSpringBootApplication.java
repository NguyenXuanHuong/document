package com.example.AmigoMongoSpringBoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmigoMongoSpringBootApplication {


	public static void main(String[] args) {
		System.out.println("port =============== "+System.getenv("PORT"));
		System.out.println("username =============== "+System.getenv("USERNAME_DB"));
		System.out.println("pwd =============== "+System.getenv("PASSWORD"));
		System.out.println("SERVER-NAME =============== "+System.getenv("SERVER_NAME"));
		System.out.println("HOST =============== "+System.getenv("HOST"));
		SpringApplication.run(AmigoMongoSpringBootApplication.class, args);

	}

}
