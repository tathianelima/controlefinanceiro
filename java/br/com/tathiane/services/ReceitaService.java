package br.com.tathiane.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tathiane.domain.Receita;
import br.com.tathiane.repositories.ReceitaRepository;
import br.com.tathiane.services.exception.ObjectNotFoundException;

@Service 
public class ReceitaService {

	@Autowired
	private ReceitaRepository repo;
	
	public Receita buscar(Integer id) {
		Optional<Receita> obj = repo.findById(id);   
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Receita.class.getName()));
		
		
	}
}
