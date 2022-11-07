package com.indra.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.biblioteca.model.Libro;
import com.indra.biblioteca.repository.LibroRepository;

@Service
public class LibroServiceImp implements LibroService{
	@Autowired
	private LibroRepository repositorio;
	
	@Override
	public List<Libro> getAllLibros() {
		return this.repositorio.findAll();
	}

	@Override
	public void saveLibro(Libro libro) {
		this.saveLibro(libro);
		
	}

	@Override
	public void deleteLibroById(Long isbn) {
		this.repositorio.deleteById(isbn);
		
	}

	@Override
	public Libro getLibroById(Long isbn) {
		Libro l = this.repositorio.findById(isbn).orElse(null);
		return l;
	}
	
	

}
