package br.com.tathiane.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MovimentoCredito extends Movimento{
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="comprador_id")
	private Comprador comprador;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cartao_id")
	private CartaoDeCredito cartao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="fatura_id")
	private FaturaCredito fatura;

	
	public MovimentoCredito() {
	}

	public MovimentoCredito(Integer id, Date data, Double valor, String descricao, Categoria categoria, Comprador comprador, CartaoDeCredito cartao, FaturaCredito fatura) {
		super(id, data, valor);
		this.descricao = descricao;
		this.categoria = categoria;
		this.comprador = comprador;
		this.cartao = cartao;
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

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public CartaoDeCredito getCartao() {
		return cartao;
	}

	public void setCartao(CartaoDeCredito cartao) {
		this.cartao = cartao;
	}

	public FaturaCredito getFatura() {
		return fatura;
	}

	public void setFatura(FaturaCredito fatura) {
		this.fatura = fatura;
	}

	
	
}
