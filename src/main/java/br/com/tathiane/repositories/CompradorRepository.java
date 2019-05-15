package br.com.tathiane.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tathiane.domain.Comprador;

@Repository // permite o acesso ao banco por metodos do spring boot JPA
public interface CompradorRepository extends JpaRepository<Comprador, Integer>{

}
