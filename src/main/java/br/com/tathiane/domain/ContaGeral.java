package br.com.tathiane.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ContaGeral implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@JsonFormat(pattern="MM/yyyy")
	private Date mes;
	
	private Double totalReal;
	private Double totalPrevisto;
	
	@OneToMany(mappedBy="contaGeral")
	private List<FaturaCredito> faturasCredito = new ArrayList<>();
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="contaGeral")
	private FaturaDebito faturaDebito;
	
	@OneToMany(mappedBy="contaGeral")
	private List<GastoPrevisto> gastosPrevistos = new ArrayList<>();
	
	@OneToMany(mappedBy="contaGeral")
	private List<Receita> receitas = new ArrayList<>();
	
	@OneToMany(mappedBy="contaGeral")
	private List<Investimento> investimentos = new ArrayList<>();
	
	public ContaGeral() {
	}

	public ContaGeral(Integer id, Date mes, Double totalReal, Double totalPrevisto) {
		super();
		this.id = id;
		this.mes = mes;
		this.totalReal = totalReal;
		this.totalPrevisto = totalPrevisto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMes() {
		return mes;
	}

	public void setMes(Date mes) {
		this.mes = mes;
	}

	public Double getTotalReal() {
		return totalReal;
	}

	public void setTotalReal(Double totalReal) {
		this.totalReal = totalReal;
	}

	public Double getTotalPrevisto() {
		return totalPrevisto;
	}

	public void setTotalPrevisto(Double totalPrevisto) {
		this.totalPrevisto = totalPrevisto;
	}

	public FaturaDebito getFaturaDebito() {
		return faturaDebito;
	}

	public void setFaturaDebito(FaturaDebito faturaDebito) {
		this.faturaDebito = faturaDebito;
	}

	public List<FaturaCredito> getFaturasCredito() {
		return faturasCredito;
	}

	public void setFaturasCredito(List<FaturaCredito> faturasCredito) {
		this.faturasCredito = faturasCredito;
	}

	public List<GastoPrevisto> getGastosPrevistos() {
		return gastosPrevistos;
	}

	public void setGastosPrevistos(List<GastoPrevisto> gastosPrevistos) {
		this.gastosPrevistos = gastosPrevistos;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public List<Investimento> getInvestimentos() {
		return investimentos;
	}

	public void setInvestimentos(List<Investimento> investimentos) {
		this.investimentos = investimentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaGeral other = (ContaGeral) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
