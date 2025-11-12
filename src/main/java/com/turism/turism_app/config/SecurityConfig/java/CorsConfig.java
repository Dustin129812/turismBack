package com.turism.turism_app.config.SecurityConfig.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
    .allowedOrigins(
        "http://localhost:8100",
        "capacitor://localhost",
        "http://192.168.100.189:8100",
        "http://10.0.2.2:8100",
        "capacitor://10.0.2.2",
        "http://localhost",
        "capacitor://10.0.2.2:8100",
        "http://10.0.2.2"
    )
    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
    .allowedHeaders("*")
    .allowCredentials(true);
            }
        };
    }
}

