package com.mauricio.apiCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
BD: ecommerce
Servidor: localhost
Usuario: admin
Contraseña: admin
Puerto: 3306
JDBC URL: jdbc:mysql://localhost:3306/ecommerce?useSSL=false&serverTimezone=UTC
*/

@SpringBootApplication
public class ApiCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCommerceApplication.class, args);
	}

}
