package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SeatBookingStatusMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatBookingStatusMicroserviceApplication.class, args);
	}

}
