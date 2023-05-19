package com.project.gestao.application.controller.v1;

import com.project.gestao.application.controller.request.PersonRequest;
import com.project.gestao.application.controller.request.ProjectRequest;
import com.project.gestao.application.controller.response.PersonResponse;
import com.project.gestao.application.controller.response.ProjectResponse;
import com.project.gestao.application.services.PessoaService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/person")
@Log4j2
public class PessoaController {

    private final PessoaService service;

    @ApiOperation(value = "List all person")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonResponse> listPerson() {
        log.info("v1 - List all person");
        return service.listPessoa();
    }

    @ApiOperation(value = "Inclusion of New Person")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void addPerson(@RequestBody PersonRequest personRequest) {
        log.info("v1 - Add person");
        service.addProject(personRequest);
    }
    @ApiOperation(value = "List all projects by status")
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProject(@RequestParam(required = false) Long id) throws Exception {
        log.info("v1 - Delete project by identifier");
        service.deleteProject(id);
    }
}
