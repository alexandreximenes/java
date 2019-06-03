package br.com.perceptron.marketplace.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static br.com.perceptron.marketplace.response.ResponseUtils.acceptLanguage;
import static br.com.perceptron.marketplace.security.Headers.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private MessageSource messageSource;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.perceptron.marketplace"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                        .name(AUTHORIZATION)
                                        .description(BEARER)
                                        .modelRef(new ModelRef("string"))
                                        .parameterType(HEADER)
                                        .required(false)
                                        .build())
                )
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                        .name(ACCEPT_LANGUAGE)
                                        .description(acceptLanguage(messageSource))
                                        .modelRef(new ModelRef("string"))
                                        .defaultValue("pt")
                                        .parameterType(HEADER)
                                        .required(false)
                                        .build())
                )
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .contact(new Contact("Alexandre Ximenes", "br.com.perceptron.marketplace", "xyymenes@gmail.com"))
                .title("Perceptron Marketplace")
                .description("Documentação API REST do Marketplace project.. descrever")
                .version("1.0")
                .termsOfServiceUrl("")
                .license("Apache Licence Version 2.0")
                .licenseUrl("https://apache.org")
                .build();
    }
}
