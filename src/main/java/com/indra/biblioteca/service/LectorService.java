package com.indra.biblioteca.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import com.indra.biblioteca.model.Lector;

public interface LectorService {
	List<Lector> getAllLectores();
	
	Lector getLectorById(Long id);
	
	void prestar(Long noSocio, Long idCopia);
	
	void devolver(Long idCopia);
}
