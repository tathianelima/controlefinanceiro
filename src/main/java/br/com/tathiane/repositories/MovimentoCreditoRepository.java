package br.com.tathiane.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tathiane.domain.MovimentoCredito;

@Repository // permite o acesso ao banco por metodos do spring boot JPA
public interface MovimentoCreditoRepository extends JpaRepository<MovimentoCredito, Integer>{

}
