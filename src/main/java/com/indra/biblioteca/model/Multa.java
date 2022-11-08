package com.indra.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "multas")
public class Multa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMulta;
	
	@Column
	private LocalDate inicio;
	
	@Column
	private LocalDate fin;

	public Long getIdMulta() {
		return idMulta;
	}
	public Multa() {
		// TODO Auto-generated constructor stub
	}

	public void setIdMulta(Long idMulta) {
		this.idMulta = idMulta;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public Multa(LocalDate inicio, LocalDate fin) {
		super();
		this.inicio = inicio;
		this.fin = fin;
	}
	
	
	
	
}
