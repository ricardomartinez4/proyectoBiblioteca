package com.indra.biblioteca.service;

import java.util.List;


import com.indra.biblioteca.model.Prestamo;

public interface PrestamoService {
	
	void savePrestamo(Prestamo prestamo);
	Prestamo getPrestamoById(Long id);
	void deletePrestamoById(Long id);
	List<Prestamo> getAllPrestamos(Long idLector);
	
}
