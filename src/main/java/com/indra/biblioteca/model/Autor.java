package com.indra.biblioteca.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="autores")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String nacionalidad;
	
	@Column
	private LocalDate fechaNacimiento;
	
	@OneToMany(mappedBy="autor", targetEntity = Libro.class, cascade = CascadeType.ALL)
	private Set<Libro> libros;

	@Override
	public String toString() {
		return this.nombre;
	}
	
	
	
}
