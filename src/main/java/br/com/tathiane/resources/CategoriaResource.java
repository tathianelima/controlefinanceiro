package br.com.tathiane.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tathiane.domain.Categoria;
import br.com.tathiane.services.CategoriaService;

//notação do spring boot que identifica um recurso
@RestController 
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	//verbo http para a operação
	@RequestMapping(value="/{id}", method=RequestMethod.GET)    // /{id} - apelido do valor que sera adicionado a url
	public ResponseEntity<?> find(@PathVariable Integer id) {     //PathVariable (para que o spring saiba que o id da url vai vir para esse id)
		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	// ok - operação com sucesso body - a resposta tem como corpo a categoria buscada	
		
		//ResponseEntity é um objeto especial do spring boot que encapsula/armazena várias informações de uma resposta http para um serviço rest
		// recebe <?> porque pode ser de vários tipos
	}
}
