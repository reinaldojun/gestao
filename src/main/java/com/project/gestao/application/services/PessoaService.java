package com.project.gestao.application.services;

import com.project.gestao.infrastructure.database.model.PessoaEntity;
import com.project.gestao.infrastructure.database.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Transactional
    public void addPessoa(PessoaEntity pessoa){
        pessoaRepository.save(pessoa);
    }

    public List<PessoaEntity> listPessoa(){
        return pessoaRepository.findAll();
    }

    public List<PessoaEntity> findPessoaByName(String name){
        return pessoaRepository.findPessoaEntitiesByNomeContains(name);
    }


}
