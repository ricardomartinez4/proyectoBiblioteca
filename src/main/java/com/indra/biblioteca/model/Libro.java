package com.indra.biblioteca.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="libros")
public class Libro{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long isbn;
	
	@Column
	private String titulo;
	
	@Column
	private String tipo;
	
	@Column
	private String editorial;
	
	@Column
	private LocalDate anyo;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="fk_autor")
	private Autor autor;
	
	@OneToMany(mappedBy="libro", targetEntity = Copia.class, cascade = CascadeType.ALL)
	private Set<Copia> copias;

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getAnyo() {
		return anyo;
	}

	public void setAnyo(LocalDate anyo) {
		this.anyo = anyo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Set<Copia> getCopias() {
		return copias;
	}

	public void setCopias(Set<Copia> copias) {
		this.copias = copias;
	}
	
	
	
}
