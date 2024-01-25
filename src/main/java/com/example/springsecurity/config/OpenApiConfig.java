package com.example.springsecurity.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Authorization",
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP)
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        Contact contact = new Contact();
        contact.setEmail("eltajgafarli@gmail.com");
        contact.setName("Eltaj");

        Info info = new Info()
                .title("Security App")
                .version("1.1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials");

        return new OpenAPI()
                .info(info)
                .addSecurityItem(new SecurityRequirement().addList("Authorization"));
    }
}
