package com.project.gestao.application.enumerations;

public enum StatusProject {
	EM_ANALISE, 
	ANALISE_REALIZADA, 
	ANALISE_APROVADA, 
	INICIADO, 
	PLANEJADO, 
	EM_ANDAMENTO, 
	ENCERRADO, 
	CANCELADO;
	
	private boolean is(StatusProject... outrosStatus) {
		for (final StatusProject outro : outrosStatus) {
			if (this == outro) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isBaixoRisco() {
		return is(EM_ANALISE, ANALISE_REALIZADA, ANALISE_APROVADA);
	}
	
	public boolean isMedioRisco() {
		return is(INICIADO, PLANEJADO, EM_ANDAMENTO);
	}
	
	public boolean isAltoRisco() {
		return is(EM_ANALISE, ANALISE_REALIZADA, ANALISE_APROVADA, INICIADO, PLANEJADO);
	}
	
	public boolean isNotExclude() {
		return is(INICIADO, EM_ANDAMENTO, ENCERRADO);
	}
}
