package com.indra.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.indra.biblioteca.model.Prestamo;


public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
