package com.project.gestao.application.controller.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFilter {
	private Integer id;
	private String nome;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")	
	private LocalDateTime dataInicio;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataPrevisaoTermino;
	private BigDecimal orcamentoTotal;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String statusProject;
}
