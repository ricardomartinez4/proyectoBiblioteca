package com.indra.biblioteca.service;

import java.util.List;

import com.indra.biblioteca.model.Autor;


public interface AutorService {
	List<Autor> getAllAutores();
	void saveAutor(Autor autor);
	Autor getAutorById(long id);
	void deleteAutorById(long id);
}
