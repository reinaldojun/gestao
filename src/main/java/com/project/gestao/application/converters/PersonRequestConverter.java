package com.project.gestao.application.converters;

import com.project.gestao.application.controller.request.PersonRequest;
import com.project.gestao.infrastructure.database.model.PessoaEntity;
import org.springframework.stereotype.Component;


@Component
public class PessoaRequestConverter implements BaseConverter<PessoaEntity, PersonRequest> {
}
