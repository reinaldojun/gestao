package com.project.gestao.application.configurations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket api() {
        final List<ResponseMessage> globalResponses = new ArrayList<>();
        globalResponses.add(new ResponseMessageBuilder()
                .code(500)
                .message("Erro desconhecido")
                .build());
        globalResponses.add(new ResponseMessageBuilder()
                .code(400)
                .message("Requisição inválida")
                .build());
        globalResponses.add(new ResponseMessageBuilder()
                .code(401)
                .message("Acesso não autenticado")
                .build());
        globalResponses.add(new ResponseMessageBuilder()
                .code(403)
                .message("Acesso não autorizado")
                .build());
        globalResponses.add(new ResponseMessageBuilder()
                .code(405)
                .message("Método não permitido")
                .build());

        return new Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(LocalDateTime.class, String.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalTime.class, String.class)
                .consumes(Set.of(MediaType.APPLICATION_JSON_VALUE))
                .produces(Set.of(MediaType.APPLICATION_JSON_VALUE))
                .protocols(Set.of("http", "https"))
                .select()
                .paths(PathSelectors.any()).build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .ignoredParameterTypes(Pageable.class)
                .globalResponseMessage(RequestMethod.GET, globalResponses)
                .globalResponseMessage(RequestMethod.POST, globalResponses)
                .globalResponseMessage(RequestMethod.PUT, globalResponses)
                .globalResponseMessage(RequestMethod.PATCH, globalResponses)
                .globalResponseMessage(RequestMethod.DELETE, globalResponses);

    }
	

}
