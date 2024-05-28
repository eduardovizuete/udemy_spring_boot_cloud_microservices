package net.javaguides.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition (
		info = @Info(
				title = "Department service REST APIs",
				description = "Department service REST APIs documentation",
				version = "V1.0",
				contact = @Contact (
						name = "test",
						email = "test@test",
						url = "http://test.io"
				),
				license = @License (
						name = "Apache 2.0",
						url = "http://test.io"
				)
		),
		externalDocs = @ExternalDocumentation (
				description = "Department-Service doc",
				url = "http://test.io"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
