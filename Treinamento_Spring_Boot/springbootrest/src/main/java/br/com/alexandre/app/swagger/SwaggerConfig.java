package br.com.alexandre.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("br.com.alexandre.app.endpoint"))
                    .paths(PathSelectors.any())
                    .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("Alexandre Ximenes", "mailto:xyymenes@gmail.com", "xyymenes@gmail.com"))
                .title("Curso Spring Boot")
                .description("Treinamento do Curso Spring Boot")
                .version("1.0")
                .license("Apache Licence Version 2.0")
                .licenseUrl("https://apache.org")
                .build();

    }
}
