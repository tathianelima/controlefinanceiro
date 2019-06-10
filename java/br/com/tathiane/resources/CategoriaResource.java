package br.com.tathiane.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tathiane.domain.Categoria;
import br.com.tathiane.dto.CategoriaDTO;
import br.com.tathiane.services.CategoriaService;

//notação do spring boot que identifica um recurso
@RestController 
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	//verbo http para a operação
	@RequestMapping(value="/{id}", method=RequestMethod.GET)    // /{id} - apelido do valor que sera adicionado a url
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {     //PathVariable (para que o spring saiba que o id da url vai vir para esse id)
		
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);	// ok - operação com sucesso body - a resposta tem como corpo a categoria buscada	
		
		//ResponseEntity é um objeto especial do spring boot que encapsula/armazena várias informações de uma resposta http para um serviço rest
		// recebe <?> porque pode ser de vários tipos
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto){ 	
		Categoria obj = service.fromDTO(objDto);
		obj = service.insert(obj); 													
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri(); 			
		return ResponseEntity.created(uri).build(); 								
	}

	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Integer id){
		Categoria obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
