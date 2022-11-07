package com.indra.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="prestamos")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestamo;
	
	@Column
	private LocalDate inicio;
	
	@Column
	private LocalDate fin;
	
	@OneToOne
	@JoinColumn(name="nSocio")
	private Lector lector;
	
	@OneToOne
	@JoinColumn(name="id")
	private Copia copia;
	
	public Prestamo() {
		// TODO Auto-generated constructor stub
	}
	

	public Prestamo(LocalDate inicio, LocalDate fin, Lector lector, Copia copia) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		this.lector = lector;
		this.copia = copia;
	}


	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
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

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}
	
	
}
