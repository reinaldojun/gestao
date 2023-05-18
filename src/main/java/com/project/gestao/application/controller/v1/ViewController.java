package com.project.gestao.application.controller.v1;

import com.project.gestao.application.controller.response.ProjectRequest;
import com.project.gestao.application.controller.response.ProjectResponse;
import com.project.gestao.application.services.PessoaService;
import com.project.gestao.application.services.ProjectService;
import com.project.gestao.infrastructure.database.model.PessoaEntity;
import com.project.gestao.infrastructure.database.model.ProjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class ViewController {

    private final ProjectService service;
    private final PessoaService pessoaService;

    @GetMapping("/home")
    public String home(Model model){
        List<ProjectResponse> projectResponse = service.listProject();

        model.addAttribute("ProjectResponse", projectResponse);

        return "home";
    }

    @GetMapping("/membros")
    public String membros(Model model){
        List<PessoaEntity> pessoaEntities = pessoaService.listPessoa();
        model.addAttribute("PessoaEntity", pessoaEntities);

        return "membros";
    }

    @GetMapping("addmembros/{id}")
    public String menbrosForm(Model model, @PathVariable(name = "id") Integer id){
        List<PessoaEntity> pessoaEntities = pessoaService.listPessoa();
        ProjectEntity projectEntity = service.getProjectById(id);

        model.addAttribute("PessoaEntity", pessoaEntities);
        model.addAttribute("ProjectEntity", projectEntity);
        return "/membros";
    }

    @PostMapping("/consulta")
    public String consultaForm(Model model, @RequestParam("inputConsulta") String inputConsulta){
        List<PessoaEntity> pessoaEntities = pessoaService.findPessoaByName(inputConsulta);

        model.addAttribute("PessoaEntity", pessoaEntities);
        return "/membros";
    }

    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") Integer id){

        ProjectEntity projectEntity = service.getProjectById(id);
        model.addAttribute("ProjectEntity", projectEntity);
        return "atualizaForm";

    }

    @PostMapping("update/{id}")
    public String alterarProjeto(@Valid ProjectEntity entity, BindingResult result, @PathVariable Integer id){

        if (result.hasErrors()){
            return "redirect:/form";
        }

        service.updateProject(entity, id);
        return "redirect:/home";
    }

    @GetMapping("/form")
    public String projetoForm(Model model, ProjectRequest projectRequest) {
        model.addAttribute("ProjectRequest", projectRequest);
        return "addProjetosForm";
    }

    @GetMapping("/formpessoa")
    public String pessoaForm(Model model, PessoaEntity pessoa) {
        model.addAttribute("PessoaEntity", pessoa);
        return "addPessoaForm";
    }


    @PostMapping("/add")
    public String novo(@Valid ProjectRequest projectRequest, BindingResult result){

        if (result.hasFieldErrors()){
            return "redirect:/form";
        }

        service.addProject(projectRequest);

        return "redirect:/home";
    }

    @PostMapping("/addpessoa")
    public String novaPessoa(@Valid PessoaEntity pessoa, BindingResult result){

        /*if (result.hasFieldErrors()){
            return "redirect:/formpessoa";
        }*/

        pessoaService.addPessoa(pessoa);

        return "redirect:/home";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(name = "id") int id, Model model) throws Exception {

        service.deleteProject((long) id);

        return "redirect:/home";
    }
}
