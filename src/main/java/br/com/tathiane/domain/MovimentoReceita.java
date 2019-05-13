package br.com.tathiane.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.tathiane.domain.enums.EstadoPagamento;

@Entity
public class MovimentoReceita extends Movimento{
	private static final long serialVersionUID = 1L;

	private String descricao;
	private Integer estadoPagamento;
	
	@ManyToOne
	@JoinColumn(name="conta_id")
	private ContaGeral contaGeral;
	
	public MovimentoReceita() {
	}

	public MovimentoReceita(Integer id, Date data, Double valor, String descricao, EstadoPagamento estadoPagamento, ContaGeral contaGeral) {
		super(id, data, valor);
		this.descricao = descricao;
		this.estadoPagamento = estadoPagamento.getCod();
		this.contaGeral = contaGeral;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	public ContaGeral getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(ContaGeral contaGeral) {
		this.contaGeral = contaGeral;
	}
	

}
