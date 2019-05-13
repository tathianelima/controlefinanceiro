package br.com.tathiane.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.tathiane.domain.enums.EstadoPagamento;

@Entity
public class MovimentoAplicacao extends Movimento{
	private static final long serialVersionUID = 1L;

	private Integer estadoPagamento;

	@ManyToOne
	@JoinColumn(name="conta_id")
	private ContaGeral contaGeral;
	
	public MovimentoAplicacao() {
	}

	public MovimentoAplicacao(Integer id, Date data, Double valor, EstadoPagamento estadoPagamento, ContaGeral contaGeral) {
		super(id, data, valor);
		this.estadoPagamento = estadoPagamento.getCod();
	}

	public Integer getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}


}
