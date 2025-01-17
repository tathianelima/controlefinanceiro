package br.com.tathiane.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tathiane.domain.Comprador;
import br.com.tathiane.dto.CompradorDTO;
import br.com.tathiane.repositories.CompradorRepository;
import br.com.tathiane.services.exception.ObjectNotFoundException;

@Service //notação do Spring boot
public class CompradorService {

	@Autowired //declaração de dependencia (será automaticamente instanciada pelo spring pelo mecanismo de injeção de dependencia ou inversão de controle
	private CompradorRepository repo;
	
	public Comprador find(Integer id) {
		Optional<Comprador> obj = repo.findById(id);    //Optional: Objeto container que carrega o objeto comprador (encapsula o objeto estando instanciado ou não)
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Comprador.class.getName()));	
	}
	
	public Comprador insert(Comprador obj) {
		obj.setId(null); 
		return repo.save(obj);
	}
	
	public Comprador update(Comprador obj) {
		Comprador newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	public Comprador fromDTO(CompradorDTO objDto) {
		return new Comprador(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Comprador newObj, Comprador obj) {
		newObj.setNome(obj.getNome());
	}
	
}
