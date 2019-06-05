package br.com.tathiane.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tathiane.domain.Comprador;
import br.com.tathiane.repositories.CompradorRepository;
import br.com.tathiane.services.exception.ObjectNotFoundException;

@Service //notação do Spring boot
public class CompradorService {

	@Autowired //declaração de dependencia (será automaticamente instanciada pelo spring pelo mecanismo de injeção de dependencia ou inversão de controle
	private CompradorRepository repo;
	
	public Comprador buscar(Integer id) {
		
		Optional<Comprador> obj = repo.findById(id);    //Optional: Objeto container que carrega o objeto comprador (encapsula o objeto estando instanciado ou não)
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Comprador.class.getName()));
		
		
	}
}
