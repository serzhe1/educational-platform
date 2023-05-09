package com.edpl.cms.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
		name = "bearer-key",
		type = SecuritySchemeType.HTTP,
		scheme = "Bearer",
		bearerFormat = "JWT"
)
public class SwaggerConfiguration {
	@Bean
	public OpenAPI baseOpenAPI() {
		return new OpenAPI()
			.info(new Info()
					  .title("Course manager service API")
					  .version("1.0.0")
					  .description("Springdoc OpenAPI"));
	}
}
