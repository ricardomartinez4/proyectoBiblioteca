package com.indra.biblioteca.service;

import java.time.LocalDate;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.biblioteca.model.Copia;
import com.indra.biblioteca.model.Lector;
import com.indra.biblioteca.model.Prestamo;
import com.indra.biblioteca.repository.CopiaRepository;
import com.indra.biblioteca.repository.LectorRepository;
import com.indra.biblioteca.repository.PrestamoRepository;

@Service
public class LectorServiceImp implements LectorService{
	
	@Autowired
	private LectorRepository lectorRepositorio;
	
	@Autowired 
	private CopiaRepository copiaRepositorio;
	
	@Autowired
	private PrestamoRepository prestamoRepositorio;

	@Override
	public List<Lector> getAllLectores() {
		// TODO Auto-generated method stub
		return this.lectorRepositorio.findAll();
	}

	

	@Override
	public Lector getLectorById(Long id) {
		Lector lector = this.lectorRepositorio.findById(id).orElse(null);
		return lector;
	}

	

	@Override
	public void prestar(Long noSocio, Long idCopia) {
		
		Copia copia = copiaRepositorio.findById(idCopia).orElse(null);
		//copia.setEstado("prestada");
		
		Lector lector = lectorRepositorio.findById(noSocio).orElse(null);
		LocalDate hoy = LocalDate.now();
		
		LocalDate finFecha = hoy.plusDays(30);
		
		Prestamo prestamo = new Prestamo(finFecha, finFecha, lector, copia);
		
		//this.copiaRepositorio.save(copia);
		this.prestamoRepositorio.save(prestamo);
		
	}



	




}
