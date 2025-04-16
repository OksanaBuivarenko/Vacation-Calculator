package com.neostudy.vacationcalculator.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@OpenAPIDefinition(
        info = @Info(
                title = "Vacation calculator application api",
                version = "1.0"),
        servers = @Server(
                description = "localhost",
                url = "http://localhost:8080/")
)
public class SwaggerConfig {
}
