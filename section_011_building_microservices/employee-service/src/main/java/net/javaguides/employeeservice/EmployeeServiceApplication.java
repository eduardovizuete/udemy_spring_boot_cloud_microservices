package net.javaguides.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee service REST APIs",
				description = "Employee service REST APIs documentation",
				version = "V1.0",
				contact = @Contact(
						name = "test",
						email = "javaguides.@net",
						url = "javaguides.net"
				),
				license = @License(
						name = "Apache 2.0",
						url = "javaguides.net/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee service doc",
				url = "javaguides.net/license/employee_service.html"
		)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
