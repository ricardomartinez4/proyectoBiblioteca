package com.indra.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.biblioteca.model.Prestamo;
import com.indra.biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoServiceImp implements PrestamoService{
	
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@Override
	public List<Prestamo> getAllPrestamos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePrestamo(Prestamo prestamo) {
		prestamoRepository.save(prestamo);
		
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

}
