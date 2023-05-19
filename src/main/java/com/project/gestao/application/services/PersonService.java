package com.project.gestao.application.services;

import com.project.gestao.application.controller.response.PersonResponse;
import com.project.gestao.application.converters.PessoaRequestConverter;
import com.project.gestao.application.converters.PessoaResponseConverter;
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
    private final PessoaRequestConverter pessoaRequestConverter;
    private final PessoaResponseConverter pessoaResponseConverter;

    @Transactional
    public void addPessoa(PessoaEntity pessoa){
        pessoaRepository.save(pessoa);
    }

    public List<PessoaEntity> listPessoa(){
        return pessoaRepository.findAll();
    }

    public List<PersonResponse> listPerson(){
        return pessoaResConverter.toListDto(pessoaRepository.findAll());
    }


    public List<PessoaEntity> findPessoaByName(String name){
        return pessoaRepository.findPessoaEntitiesByNomeContains(name);
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }


}
