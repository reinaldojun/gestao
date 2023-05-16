package com.project.gestao.application.converters;

import org.springframework.stereotype.Component;

import com.project.gestao.application.controller.response.ProjectResponse;
import com.project.gestao.infrastructure.database.model.ProjectEntity;


@Component
public class ProjectResponseConverter implements BaseConverter<ProjectEntity, ProjectResponse> {
}
