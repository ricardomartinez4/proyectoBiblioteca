package com.indra.biblioteca.service;

import java.util.List;


import com.indra.biblioteca.model.Lector;

public interface LectorService {
	List<Lector> getAllLectores();
	void saveLector(Lector lector);
	Lector getLectorById(Long id);
	void deleteLectorById(Long id);
}
