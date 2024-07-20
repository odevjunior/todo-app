package com.studies.todo_app.config;

import com.studies.todo_app.models.translate.client.TranslateApiClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TranslateApiClient translateApiClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logLevel(Logger.Level.FULL)
                .target(TranslateApiClient.class, "https://google-translate113.p.rapidapi.com/api/v1/");
    }
}
