package com.project.gestao.infrastructure.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.gestao.application.enumerations.StatusProject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
@Table(name = "project")
public class ProjectEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "description")
	private String description;
	
	@Column(name = "data_inicio")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;
	
	@Column(name = "data_previsao_termino")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataPrevisaoTermino;
	
	@Column(name = "data_real_termino")
	private LocalDateTime dataRealTermino;
	
	@Column
	private BigDecimal orcamento;
	
	@JoinColumn(name = "idgerente", referencedColumnName = "id")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private PessoaEntity idGerente;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private StatusProject statusProject = StatusProject.EM_ANALISE;
	
	@ManyToMany
	@JoinTable(name = "membros",
			inverseJoinColumns = {@JoinColumn(name = "pessoa_id")},
			joinColumns = {@JoinColumn(name = "project_id")})
	private List<PessoaEntity> pessoas = new ArrayList<>();
	
}
