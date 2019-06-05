package br.com.tathiane.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tathiane.domain.ContaGeral;
import br.com.tathiane.services.ContaGeralService;

//notação do spring boot que identifica um recurso
@RestController 
@RequestMapping(value="/contasGerais")
public class ContaGeralResource {
	
	@Autowired
	private ContaGeralService service;
	
	//verbo http para a operação
	@RequestMapping(value="/{id}", method=RequestMethod.GET)    
	public ResponseEntity<?> find(@PathVariable Integer id) {    
		
		ContaGeral obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
	}
}
