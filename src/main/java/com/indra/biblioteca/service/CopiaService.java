package com.indra.biblioteca.service;

import java.util.List;

import com.indra.biblioteca.model.Copia;

public interface CopiaService {
	List<Copia> getAllCopias(Long isbn);
	Copia getCopiaById(Long id);
}
