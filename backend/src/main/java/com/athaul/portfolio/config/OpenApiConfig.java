package com.athaul.portfolio.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI definition, including JWT Bearer authentication for secured endpoints.
 */
@Configuration
public class OpenApiConfig {

    private static final String BEARER_SCHEME = "bearerAuth";

    @Bean
    public OpenAPI portfolioOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Portfolio Backend API")
                        .version("v1")
                        .description("REST API for the portfolio application."))

                // Tell Swagger that the API uses JWT Bearer Authentication
                .addSecurityItem(new SecurityRequirement().addList(BEARER_SCHEME))

                .components(new Components()
                        .addSecuritySchemes(BEARER_SCHEME,
                                new SecurityScheme()
                                        .name(BEARER_SCHEME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}