package com.java.websocketts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class WebsockettsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsockettsApplication.class, args);
	}

}
