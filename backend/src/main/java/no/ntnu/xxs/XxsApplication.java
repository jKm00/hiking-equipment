package no.ntnu.xxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class XxsApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxsApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfiguration () {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("no.ntnu.xxs"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
			"XXS - API",
			"API for the XXS-project in application programming at ntnu",
			"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Group 02", "gr02.appdev.cloudns.ph", "gr02@ntnu.no"),
				"Api License",
				"ntnu.no",
				Collections.emptyList()
				);
	}


}
