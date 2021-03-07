package br.com.vacinacao.VacinacaoAPI.swaggerConfig;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket vacinacaoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
                .apis(RequestHandlerSelectors.basePackage("br.com.vacinacao.VacinacaoAPI"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "API REST Controle de Aplicação de Vacinas",
                "API REST Manipulação de vacinas em Brasileiros.",
                "1.0",
                "Terms of Service",
                new Contact("Christian Rodrigues", "-",
                        "christianmoura.moura@hotmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;

    }
}
