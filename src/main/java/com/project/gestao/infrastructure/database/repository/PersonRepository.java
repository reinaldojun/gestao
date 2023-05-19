package com.project.gestao.infrastructure.database.repository;

import com.project.gestao.infrastructure.database.model.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

    List<PessoaEntity> findPessoaEntitiesByNomeContains(String nome);
}
