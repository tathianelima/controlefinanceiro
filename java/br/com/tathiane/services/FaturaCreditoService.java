package br.com.tathiane.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tathiane.domain.FaturaCredito;
import br.com.tathiane.repositories.FaturaCreditoRepository;
import br.com.tathiane.services.exception.ObjectNotFoundException;

@Service //notação do Spring boot
public class FaturaCreditoService {

	@Autowired //declaração de dependencia (será automaticamente instanciada pelo spring pelo mecanismo de injeção de dependencia ou inversão de controle
	private FaturaCreditoRepository repo;
	
	public FaturaCredito buscar(Integer id) {
		Optional<FaturaCredito> obj = repo.findById(id);    //Optional: Objeto container que carrega o objeto FaturaCredito (encapsula o objeto estando instanciado ou não)
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + FaturaCredito.class.getName()));
		
		
	}
}
