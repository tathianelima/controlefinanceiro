package br.com.tathiane.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tathiane.domain.Comprador;
import br.com.tathiane.dto.CompradorDTO;
import br.com.tathiane.services.CompradorService;

//notação do spring boot que identifica um recurso
@RestController 
@RequestMapping(value="/compradores")
public class CompradorResource {
	
	@Autowired
	private CompradorService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)    
	public ResponseEntity<?> find(@PathVariable Integer id) {     
		Comprador obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CompradorDTO objDto){ 	
		Comprador obj = service.fromDTO(objDto);
		obj = service.insert(obj); 													
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri(); 			
		return ResponseEntity.created(uri).build(); 								
	}
}
