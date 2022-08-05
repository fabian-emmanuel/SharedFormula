package com.sharedformula.wallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("WALLET SERVICE API")
				.description("")
				.termsOfServiceUrl("").version("0.0.1").contact(new Contact("FABIAN EMMANUEL", "https://github.com/fabian-emmanuel", "https://github.com/fabian-emmanuel")).build();
	}

	@Bean
	public Docket configureControllerPackageAndConvertors() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sharedformula.wallet.controller")).build()
				.apiInfo(apiInfo());
	}
}