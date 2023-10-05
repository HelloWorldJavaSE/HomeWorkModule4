package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@ComponentScan("com.example.demo")
@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Bean
    public String helloBeanString(){
        return "hello";
    }
}
