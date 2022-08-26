package com.example.demoserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalTime;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket( DocumentationType.SWAGGER_2 )
                       .directModelSubstitute( LocalTime.class, String.class ).select()
                       .apis( RequestHandlerSelectors.basePackage("com.example.demoserver.controller") )
                       .paths( PathSelectors.any() )
                       .build()
                       .apiInfo( apiInfo() );
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfo(
                "Demo Server API",
                "Demo server for working as an API",
                "v1",
                "Terms of service",
                new Contact( "--", "--", "--" ),
                "License of API", "API license URL", Collections.emptyList() );
    }
}
