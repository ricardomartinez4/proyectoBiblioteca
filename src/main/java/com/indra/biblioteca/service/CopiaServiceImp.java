package com.indra.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.biblioteca.model.Copia;

import com.indra.biblioteca.repository.CopiaRepository;

@Service
public class CopiaServiceImp implements CopiaService {

	@Autowired
	private CopiaRepository copiaRepositorio;

	@Override
	public List<Copia> getAllCopias(Long isbn) {
		List<Copia> listaCopias = copiaRepositorio.findAllById(isbn);
		if(listaCopias.isEmpty()) {
			return null;
		}
		return listaCopias;

	}

	@Override
	public Copia getCopiaById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
