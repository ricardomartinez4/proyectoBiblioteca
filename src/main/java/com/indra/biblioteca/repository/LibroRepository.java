package com.indra.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.biblioteca.model.Libro;



public interface LibroRepository extends JpaRepository<Libro, Long>{

}
