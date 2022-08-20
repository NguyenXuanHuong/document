package com.example.clientTestHttps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFeignConfiguration {

  @Bean
  public void Config() {
    System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
    System.setProperty("javax.net.ssl.keyStore", "src/main/resources/baeldung.p12");
    System.setProperty("javax.net.ssl.keyStorePassword", "huong1998");
  }
}
