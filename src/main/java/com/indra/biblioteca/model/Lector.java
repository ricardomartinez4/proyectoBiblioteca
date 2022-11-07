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
@Table(name="lectores")
public class Lector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nSocio;
	
	@Column
	private String nombre;
	
	@Column
	private String telefono;
	
	@Column
	private String direccion;
	
	@OneToOne 
    @JoinColumn(name="idMulta")
	private Multa multa;
	
	
	
	public Long getnSocio() {
		return nSocio;
	}

	public void setnSocio(Long nSocio) {
		this.nSocio = nSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public void prestar(Long isbn, LocalDate fecha) {
		
	}
	
	private void multar(int dias) {
		
	}
	
	public void devolver(Long isbn, LocalDate fechaActual) {
		
	}
	
}
