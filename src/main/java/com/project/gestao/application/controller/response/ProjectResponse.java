package com.project.gestao.application.controller.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer id;
	private String nome;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataPrevisaoTermino;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataFim;
	private BigDecimal orcamento;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String statusProject;
}
