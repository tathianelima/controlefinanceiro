package br.com.tathiane.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tathiane.domain.Receita;
import br.com.tathiane.services.ReceitaService;

@RestController 
@RequestMapping(value="/receitas")
public class ReceitaResource {
	
	@Autowired
	private ReceitaService service;
	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)    
	public ResponseEntity<?> find(@PathVariable Integer id) {    
		
		Receita obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
	}
}
