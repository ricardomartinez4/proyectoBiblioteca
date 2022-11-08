package com.indra.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.biblioteca.model.Multa;
import com.indra.biblioteca.repository.MultaRepository;

@Service
public class MultaServiceImp implements MultaService{
	@Autowired
	private MultaRepository repositorio;
	
	@Override
	public List<Multa> getAllMultas() {
		return repositorio.findAll();
	}

	@Override
	public void saveMulta(Multa multa) {
		this.repositorio.save(multa);
		
	}

	@Override
	public Multa getMultaById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMultaById(Multa multa) {
		this.repositorio.delete(multa);
		
	}

}
