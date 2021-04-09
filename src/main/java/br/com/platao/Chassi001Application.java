package br.com.platao;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Chassi001Application {

	public static void main(String[] args) {
		SpringApplication.run(Chassi001Application.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/students/*"))
				.apis(RequestHandlerSelectors.basePackage("br.com.platao"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Chassi Platão API", 
	      "Aplicação experimental de novas tecnologias.", 
	      "API TOS", 
	      "Terms of service", 
	      new Contact("Luis Franco", "www.luisfranco.com", "lhpfranco@hotmail.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

}
