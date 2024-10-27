package com.n1b3lung0.gymrat.config.openApi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    private static final String devUrl = "http://localhost:8080";
    private static final String prodUrl = "https://n1b3lung0-api.com";

    private static final String DEVSERVER_DESCRIPTION = "Server URL in Development Environment";
    private static final String PRODSERVER_DESCIPTION = "Server URL in Production Environment";

    @Bean
    public OpenAPI openAPI() {
        Contact contact = new Contact()
                .email("carlos.martinez.crespo@gmail.com")
                .name("n1b3lung0")
                .url("https://github.com/n1b3lung0/gymrat");

        License license = new License().name("MIT License").url("https://github.com/n1b3lung0/gymrat");

        Info info = new Info()
                .title("Gymrat API")
                .version("1.0")
                .contact(contact)
                .description("API to manage GYM exercises")
                .license(license);

        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription(DEVSERVER_DESCRIPTION);

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription(PRODSERVER_DESCIPTION);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
