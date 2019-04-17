package br.com.tathiane.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//notação do spring que identifica um recurso
@RestController 
@RequestMapping(value="/classificacoesDeGasto")
public class ClassificacaoDeGastoResource {

	//verbo http para a operação
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "funcionando";
		
	}
}
