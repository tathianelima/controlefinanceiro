package br.com.tathiane.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tathiane.domain.Credito;

@Repository // permite o acesso ao banco por metodos do spring boot JPA
public interface CreditoRepository extends JpaRepository<Credito, Integer>{

}
