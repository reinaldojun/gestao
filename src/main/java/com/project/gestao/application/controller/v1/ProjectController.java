package com.project.gestao.application.controller.v1;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.gestao.application.controller.response.ProjectRequest;
import com.project.gestao.application.controller.response.ProjectResponse;
import com.project.gestao.application.services.ProjectService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/projects")
@Log4j2
public class ProjectController {
	private final ProjectService service;

	@ApiOperation(value = "List all Projects")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProjectResponse> listProject() {
		log.info("v1 - List all projects");
		return service.listProject();
	}
	
	@ApiOperation(value = "Inclusion of New Projects")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void addProject(@RequestBody ProjectRequest projectRequest) {
		log.info("v1 - Add project");
		service.addProject(projectRequest);
	}
	
	@ApiOperation(value = "List all projects by status")
	@GetMapping(value = "status", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProjectResponse> listProjectByStatus(@RequestParam(required = false) String status) {
		log.info("v1 - List all projects by status");
		return service.listProjectByStatus(status);
	}
	
	@ApiOperation(value = "List all projects by status")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteProject(@RequestParam(required = false) Long id) throws Exception {
		log.info("v1 - Delete project by identifier");
		service.deleteProject(id);
	}
}
