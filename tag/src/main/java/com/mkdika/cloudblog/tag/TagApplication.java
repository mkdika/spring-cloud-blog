package com.mkdika.cloudblog.tag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TagApplication {
    public static void main(String[] args) {
        SpringApplication.run(TagApplication.class, args);
    }
}
