package com.afzdev.gameapi.config;


import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpeAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("GAME API")
                        .description("API SIMPLES CATALOGO DE GAMES")
                        .version("1.0.0"));
    }
}
