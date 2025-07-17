package com.querubines.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = {"com.querubines.commons.controller", "com.querubines.clientes"})
@EntityScan(basePackages = "com.querubines.commons.models.entities")
@EnableFeignClients
public class ClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
