package br.com.tathiane.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tathiane.domain.ContaGeral;
import br.com.tathiane.repositories.ContaGeralRepository;
import br.com.tathiane.services.exception.ObjectNotFoundException;

@Service //notação do Spring boot
public class ContaGeralService {

	@Autowired //declaração de dependencia (será automaticamente instanciada pelo spring pelo mecanismo de injeção de dependencia ou inversão de controle
	private ContaGeralRepository repo;
	
	public ContaGeral buscar(Integer id) {
		Optional<ContaGeral> obj = repo.findById(id);    //Optional: Objeto container que carrega o objeto ContaGeral (encapsula o objeto estando instanciado ou não)
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ContaGeral.class.getName()));
		
		
	}
}
