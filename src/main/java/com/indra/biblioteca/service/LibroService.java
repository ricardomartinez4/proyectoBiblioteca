package com.indra.biblioteca.service;

import java.util.List;

import com.indra.biblioteca.model.Libro;

public interface LibroService {
	List<Libro> getAllLibros();
	void saveLibro(Libro libro);
	Libro getLibroById(Long isbn);
	void deleteLibroById(Long isbn);
}
