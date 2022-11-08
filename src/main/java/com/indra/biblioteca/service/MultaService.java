package com.indra.biblioteca.service;

import java.util.List;

import com.indra.biblioteca.model.Multa;

public interface MultaService {
	List<Multa> getAllMultas();
	void saveMulta(Multa multa);
	Multa getMultaById(long id);
	void deleteMultaById(Multa multa);
}
