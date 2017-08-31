package com.mkdika.cloudblog.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@ConfigurationProperties
public class PostApplication {
	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
	}
}
