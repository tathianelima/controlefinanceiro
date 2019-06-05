package br.com.tathiane.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.tathiane.domain.Categoria;
import br.com.tathiane.dto.CategoriaDTO;
import br.com.tathiane.repositories.CategoriaRepository;
import br.com.tathiane.services.exception.DataIntegrityException;
import br.com.tathiane.services.exception.ObjectNotFoundException;

@Service //notação do Spring boot
public class CategoriaService {

	@Autowired //declaração de dependencia (será automaticamente instanciada pelo spring pelo mecanismo de injeção de dependencia ou inversão de controle
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);    //Optional: Objeto container que carrega o objeto categoria (encapsula o objeto estando instanciado ou não)
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));	
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null); 
		return repo.save(obj);
	}
	
	
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos associados");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
	
}
