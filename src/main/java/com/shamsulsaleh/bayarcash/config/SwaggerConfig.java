package com.shamsulsaleh.bayarcash.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BayarCash Spring Boot API")
                        .version("1.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                        		.name("Shamsul Saleh")
                        		.email("shamsul.saleh@gmail.com"))
                        .description("Microservice for BayarCash payment gateway."));
    }
}