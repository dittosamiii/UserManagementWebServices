package com.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title= "User Management WebServices",
				description="Spring Boot REST API Documentation",
				version= "v1.0",
				contact= @Contact(
						name="Samarth",
						email="samarth.nmamit@gmail.com",
						url="#"
						),
				license=@License(
						name="Apache 2.0",
						url="#"
						)
				),
		externalDocs= @ExternalDocumentation(
				description="Spring Boot User Management Description",
				url="#"
				)
		)
public class RestfulWebservicesApplication {
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebservicesApplication.class, args);
	}

}
