package com.github.sneha.url_shortner.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * This class configures OpenAPI for API documentation.
 * It sets up API metadata, server URLs, and contact details.
 *
 * @author sneharavikumartl
 */

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(
                        List.of(
                                new Server().url("http://localhost:8080").description("Application Server"),
                                new Server().url("http://localhost:9000").description("Management Server")
                        )
                )
                .info(new Info()
                        .title("URL Shortner Application API")
                        .description("OpenAPI documentation for URL Shortner Application")
                        .version("1.0")
                        .contact(new Contact().name("Sneha").email("sneharavikumar98@gmail.com"))
                );

    }
}
