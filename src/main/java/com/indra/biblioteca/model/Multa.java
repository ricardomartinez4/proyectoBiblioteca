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
	
	
}
