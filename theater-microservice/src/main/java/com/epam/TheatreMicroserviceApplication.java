package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TheatreMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreMicroserviceApplication.class, args);
	}

}
