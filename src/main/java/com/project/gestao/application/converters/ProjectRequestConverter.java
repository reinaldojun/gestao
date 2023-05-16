package com.project.gestao.application.converters;

import org.springframework.stereotype.Component;

import com.project.gestao.application.controller.response.ProjectRequest;
import com.project.gestao.infrastructure.database.model.ProjectEntity;


@Component
public class ProjectRequestConverter implements BaseConverter<ProjectEntity, ProjectRequest> {
}
