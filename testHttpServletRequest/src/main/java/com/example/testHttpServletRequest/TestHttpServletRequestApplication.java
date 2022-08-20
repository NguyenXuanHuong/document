package com.example.testHttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TestHttpServletRequestApplication {



	public static void main(String[] args) {
		SpringApplication.run(TestHttpServletRequestApplication.class, args);
	}


}
