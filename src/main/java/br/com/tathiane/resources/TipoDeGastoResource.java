package br.com.tathiane.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tathiane.domain.Categoria;

//notação do spring boot que identifica um recurso
@RestController 
@RequestMapping(value="/categorias")
public class TipoDeGastoResource {
	
	//verbo http para a operação
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Alimentacao");
		Categoria cat2 = new Categoria(1, "Saude");
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		return lista;
		
	}
}
