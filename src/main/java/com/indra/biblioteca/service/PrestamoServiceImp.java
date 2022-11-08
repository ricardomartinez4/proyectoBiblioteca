package com.indra.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.biblioteca.model.Copia;
import com.indra.biblioteca.model.Lector;
import com.indra.biblioteca.model.Prestamo;
import com.indra.biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoServiceImp implements PrestamoService{
	
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	

	@Override
	public void savePrestamo(Prestamo prestamo) {
		this.prestamoRepository.save(prestamo);
		
	}

	@Override
	public Prestamo getPrestamoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePrestamoById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prestamo> getAllPrestamos(Long noSocio) {
		List<Prestamo> listaPrestamos = this.prestamoRepository.findAll();
		List<Prestamo> listaPrestamosFinal = new ArrayList<>();
		
		for(Prestamo p : listaPrestamos) {
			if(p.getLector().getnSocio().equals(noSocio)) {
				listaPrestamosFinal.add(p);
			}
		}
		return listaPrestamosFinal;
	}

	

}
