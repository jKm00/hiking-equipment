package no.ntnu.xxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
				.build();


	}



}
