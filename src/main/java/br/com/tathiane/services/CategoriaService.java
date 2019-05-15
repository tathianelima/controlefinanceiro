package br.com.tathiane.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tathiane.domain.Categoria;
import br.com.tathiane.repositories.CategoriaRepository;
import br.com.tathiane.services.exception.ObjectNotFoundException;

@Service //notação do Spring boot
public class CategoriaService {

	@Autowired //declaração de dependencia (será automaticamente instanciada pelo spring pelo mecanismo de injeção de dependencia ou inversão de controle
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);    //Optional: Objeto container que carrega o objeto categoria (encapsula o objeto estando instanciado ou não)
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
		
	}
}
