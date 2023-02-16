package com.example.insurancecampaign;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;;


@SpringBootApplication
@OpenAPIDefinition
public class InsuranceCampaignApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceCampaignApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("InsuranceCampaign") String description,
                                 @Value("1.0") String version){
        return new OpenAPI()
                .info(new Info()
                        .title("InsuranceCampaign")
                        .version(version)
                        .description(description)
                        .license(new License().name("InsuranceCampaign")));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");

            }
        };
    }

}
