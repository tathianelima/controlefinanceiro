package br.com.tathiane.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.tathiane.domain.enums.EstadoPagamento;

@Entity
public class MovimentoGastoPrevisto extends Movimento{
	private static final long serialVersionUID = 1L;
	
	private Date mes;
	private String descricao;
	private Integer estadoPagamento;
	
	@ManyToOne
	@JoinColumn(name="conta_id")
	private ContaGeral contaGeral;
	
	public MovimentoGastoPrevisto() {
	}

	public MovimentoGastoPrevisto(Integer id, Date data, Double valor, Date mes, String descricao, EstadoPagamento estadoPagamento, ContaGeral contaGeral) {
		super(id, data, valor);
		this.mes = mes;
		this.descricao = descricao;
		this.estadoPagamento = estadoPagamento.getCod();
		this.contaGeral = contaGeral;
	}

	public ContaGeral getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(ContaGeral contaGeral) {
		this.contaGeral = contaGeral;
	}

	public Date getMes() {
		return mes;
	}

	public void setMes(Date mes) {
		this.mes = mes;
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
	
	
	
	
}
