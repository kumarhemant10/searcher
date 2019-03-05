package com.hk.prj.vite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;


/**
 * 
 * configuration for swagger documentation
 * 
 * @since 11-Feb-2019
 * @version 1.0.0
 * @author Hemant.Kumar
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hk.prj.vite.controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo("REST APIs", "API available in system",
                "1.0", "Terms of service", new Contact("Hemant Kumar", null, "kumar.hemant@live.com"),
                "open", null);
        return apiInfo;
    }
}
