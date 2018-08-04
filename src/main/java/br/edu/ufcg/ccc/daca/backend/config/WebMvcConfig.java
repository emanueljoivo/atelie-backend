package br.edu.ufcg.ccc.daca.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                    "http://localhost:8080",
                    "https://assueria-b46eb.firebaseapp.com",
                    "https://assueria-client.firebaseapp.com")
                .allowedMethods("POST", "GET", "PUT", "DELETE")
                .allowedHeaders("Content-Type")
                .allowCredentials(false)
                .maxAge(6000);
    }
}