package com.washuu.consumer.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeginConfig {

    @Bean
    Logger.Level feignLogger() {
       return Logger.Level.FULL;
    }

}
