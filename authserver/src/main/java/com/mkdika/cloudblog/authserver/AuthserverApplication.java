package com.mkdika.cloudblog.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthserverApplication.class, args);
    }
}
