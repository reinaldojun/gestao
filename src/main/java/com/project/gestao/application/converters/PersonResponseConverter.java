package com.project.gestao.application.converters;

import com.project.gestao.application.controller.response.PersonResponse;
import com.project.gestao.infrastructure.database.model.PessoaEntity;
import org.springframework.stereotype.Component;


@Component
public class PessoaResponseConverter implements BaseConverter<PessoaEntity, PersonResponse> {
}
