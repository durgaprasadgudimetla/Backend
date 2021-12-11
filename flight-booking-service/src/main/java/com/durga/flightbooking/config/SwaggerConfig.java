package com.durga.flightbooking.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

	@Bean
	public Docket api() {
		/* return new Docket(DocumentationType.SWAGGER_2)  
		          .select()                                  
		          .apis(RequestHandlerSelectors.any())              
		          .paths(PathSelectors.any())                          
		          .build(); */ 
		 return new Docket(DocumentationType.SWAGGER_2)
	                .select().apis(RequestHandlerSelectors.basePackage("com.durga.flightbooking"))
	               // .paths(PathSelectors.regex("/product.*"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(metaData());
		 
	}
	
	@SuppressWarnings("rawtypes")
	List<VendorExtension> vendorExtensions = new ArrayList<>();
	private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo(
	                "Spring Boot Kafka Producer API",
	                "Spring Boot Kafka Producer API",
	                "1.0",
	                "Terms of service",
	                new Contact("Durga prasad", "http://javafree4u.blogspot.com/", "prasad.javadp@gmail.com"),
	               "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0", vendorExtensions);
	        return apiInfo;
	    }



}
