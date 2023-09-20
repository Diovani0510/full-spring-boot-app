package com.example.springboot.infra.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "API de POCS",
                        email = "diovani.teste@gmail.com"
                ),
                description = "Essa API foi feita com o intuito de testar conceitos para fixar conhecimentos de desenvolvimento de uma API em Java com Spring Boot",
                title = "API de POCS"
        )
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
