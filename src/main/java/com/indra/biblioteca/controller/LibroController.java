package com.indra.biblioteca.controller;

import java.time.LocalDate;
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
import com.indra.biblioteca.model.Multa;
import com.indra.biblioteca.model.Prestamo;
import com.indra.biblioteca.service.CopiaService;
import com.indra.biblioteca.service.LectorService;
import com.indra.biblioteca.service.LibroService;
import com.indra.biblioteca.service.MultaService;
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
	
	@Autowired
	private MultaService multaService;
	
	
	@GetMapping(path={""})
	public String viewHomePage(Model model){
		List<Libro> libros = libroService.getAllLibros();
		model.addAttribute("listLibros", libros);
		
		// buscar prestamos para generar multas
		
		LocalDate hoy = LocalDate.now();
		
		List<Prestamo> losPrestamos = this.prestamoService.getAllPrestamos();
		
		for(Prestamo p : losPrestamos) {
			if(p.getFin().isBefore(hoy)) {
				
				LocalDate finMulta = hoy.plusDays(2);
				Multa multa = new Multa(hoy,finMulta);
				
				this.multaService.saveMulta(multa);
				Lector lectorAMultar = p.getLector();
				lectorAMultar.setMulta(multa);
				
				this.lectorService.editarLector(lectorAMultar);
			}
		}
		
		// buscamos en las multas para ver si han caducado
		
		List<Lector> listaLectores = this.lectorService.getAllLectores();
		List<Multa> listaMultas = this.multaService.getAllMultas();
		
		for(Multa m : listaMultas) {
			
			if(m.getFin().isBefore(hoy)) {
				
				for(Lector l : listaLectores) {
					
					if(l.getMulta()!=null) {
						if(l.getMulta().equals(m)) {
							l.setMulta(null);
							this.lectorService.editarLector(l);
							this.multaService.deleteMultaById(m);
						}
					}
				}
			}
		}
		
		
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
	
	@GetMapping("/devolverEjemplar/{idCopia}")
	public String DevolverEjemplarPage(@PathVariable(value="idCopia") Long isbn, Model model) {
		
		lectorService.devolver(isbn);
		
		return "redirect:/";
	}
	
	
	
	
}
