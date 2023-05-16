package com.project.gestao.infrastructure.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gestao.application.enumerations.StatusProject;
import com.project.gestao.infrastructure.database.model.ProjectEntity;


@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    List<ProjectEntity> findAllByStatusProject(StatusProject statusProject);
}
