package com.senapicpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SenapicpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenapicpayApplication.class, args);
	}

	// Definir um bean RestTemplate para ser usado na aplicação
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}