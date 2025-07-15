package com.querubines.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.querubines.commons.controller", "com.querubines.clientes"})
@EntityScan(basePackages = "com.querubines.commons.models.entities")
public class ClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
