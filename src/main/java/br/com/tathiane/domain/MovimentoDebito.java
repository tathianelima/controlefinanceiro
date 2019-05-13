package br.com.tathiane.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovimentoDebito extends Movimento{
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="fatura_id")
	private FaturaDebito fatura;
	
	public MovimentoDebito() {
	}

	public MovimentoDebito(Integer id, Date data, Double valor, String descricao, Categoria categoria, FaturaDebito fatura) {
		super(id, data, valor);
		this.descricao = descricao;
		this.categoria = categoria;
		this.fatura = fatura;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public FaturaDebito getFatura() {
		return fatura;
	}

	public void setFatura(FaturaDebito fatura) {
		this.fatura = fatura;
	}
	
	
}
