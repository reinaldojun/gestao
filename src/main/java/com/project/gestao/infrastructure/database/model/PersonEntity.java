package com.project.gestao.infrastructure.database.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class PessoaEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datanascimento;
	
	@Column(length = 14)
	private String cpf;
	
    @Column
	private boolean funcionario;
    
    @ManyToMany
	@JoinTable(name = "membros",
			joinColumns = {@JoinColumn(name = "project_id")},
			inverseJoinColumns = {@JoinColumn(name = "pessoa_id")})
	private Set<ProjectEntity> projetos;

}
