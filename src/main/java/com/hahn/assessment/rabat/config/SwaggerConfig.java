package com.hahn.assessment.rabat.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Your API", version = "1.0", description = "API Documentation"))
public class SwaggerConfig {
    // Additional Swagger configuration (if needed)
}