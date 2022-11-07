package com.indra.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="prestamos")
public class Prestamo {
	
	@Id
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
	
}
