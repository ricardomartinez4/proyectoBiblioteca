package com.indra.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.biblioteca.model.Copia;



public interface CopiaRepository extends JpaRepository<Copia, Long>{

	List<Copia> findAllById(Long isbn);

}
