package com.indra.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.biblioteca.model.Lector;
import com.indra.biblioteca.repository.LectorRepository;

@Service
public class LectorServiceImp implements LectorService{
	
	@Autowired
	private LectorRepository repositorio;

	@Override
	public List<Lector> getAllLectores() {
		// TODO Auto-generated method stub
		return this.repositorio.findAll();
	}

	@Override
	public void saveLector(Lector lector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lector getLectorById(Long id) {
		Lector lector = this.repositorio.findById(id).orElse(null);
		return lector;
	}

	@Override
	public void deleteLectorById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
