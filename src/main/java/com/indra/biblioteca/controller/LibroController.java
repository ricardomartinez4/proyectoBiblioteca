package com.indra.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.biblioteca.model.Copia;
import com.indra.biblioteca.model.Lector;
import com.indra.biblioteca.model.Libro;
import com.indra.biblioteca.model.Prestamo;
import com.indra.biblioteca.service.CopiaService;
import com.indra.biblioteca.service.LectorService;
import com.indra.biblioteca.service.LibroService;
import com.indra.biblioteca.service.PrestamoService;



@Controller
public class LibroController {
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private LectorService lectorService;
	
	@Autowired
	private CopiaService copiaService;
	
	@Autowired
	private PrestamoService prestamoService;
	
	@GetMapping(path={""})
	public String viewHomePage(Model model){
		List<Libro> libros = libroService.getAllLibros();
		model.addAttribute("listLibros", libros);
		return "index";
	}
	
	@GetMapping("/copias/{isbn}")
	public String showForm(@PathVariable(value="isbn") Long isbn,Model model) {
		
		
		Libro libro = libroService.getLibroById(isbn);
		List<Copia> copias = copiaService.getAllCopias(isbn);
		List<Lector> lectores = lectorService.getAllLectores();
		model.addAttribute("lectores", lectores);
		
		model.addAttribute("copias", copias);
		model.addAttribute("libro", libro);
		
		return "copias";
	}
	
	@GetMapping("/nuevoPrestamo/{idCopia}")
	public String FormPrestar(@PathVariable(value="idCopia") Long isbn, Model model) {
		Copia copia = copiaService.getCopiaById(isbn);
		
		
		model.addAttribute("copia", copia);
		model.addAttribute("idCopia", isbn);
		
		List<Lector> lectores = lectorService.getAllLectores();
		model.addAttribute("lectores", lectores);
		
		return "nuevoPrestamo";
	}
	
	@GetMapping("/prestar/{copia}/{lector}")
	public String prestar(@PathVariable(value="copia") Long idCopia, 
			@PathVariable(value="lector") Long idLector,
			Model model) {
		List<Prestamo> listaPrestamos = this.prestamoService.getAllPrestamos(idLector);
		if(listaPrestamos.size() < 3) {
			lectorService.prestar(idLector, idCopia);
		}
		return "redirect:/";
	}
	
	
	
	
	
	
}
