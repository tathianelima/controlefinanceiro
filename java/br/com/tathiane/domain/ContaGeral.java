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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tathiane.domain.enums.EstadoPagamento;

@Entity
public class ContaGeral implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@JsonFormat(pattern="MM/yyyy")
	private Date mes;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="contaGeral")
	private List<FaturaCredito> faturasCredito = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="contaGeral")
	private List<Debito> comprasDebito = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="contaGeral")
	private List<GastoPrevisto> gastosPrevistos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="contaGeral")
	private List<Receita> receitas = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="contaGeral")
	private List<Investimento> investimentos = new ArrayList<>();
	
	
	
	public ContaGeral() {
	}

	public ContaGeral(Integer id, Date mes) {
		super();
		this.id = id;
		this.mes = mes;
	}
	
	public Double getTotalReceitas() {
		double soma =0.0;
		for(Receita rc : receitas) {
			soma = soma + rc.getValor();
		}
		return soma;
	}
	
	public Double getTotalGastoPrevisto() {
		double soma =0.0;
		for(GastoPrevisto gp : gastosPrevistos) {
			soma = soma + gp.getValor();
		}
		return soma;
	}
	
	public Double getTotalInvestimentos() {
		double soma =0.0;
		for(Investimento iv : investimentos) {
			soma = soma + iv.getValor();
		}
		return soma;
	}
	
	public Double getTotalDebito() {
		double soma =0.0;
		for(Debito db : comprasDebito) {
			soma = soma + db.getValor();
		}
		return soma;
	}
	
	public Double getTotalFaturasCredito() {
		double soma =0.0;
		for(FaturaCredito fd : faturasCredito) {
			soma = soma + fd.getTotal();
		}
		return soma;
	}
	
	public Double getTotalPrevisto() {
		return getTotalReceitas() - (getTotalGastoPrevisto()+getTotalInvestimentos()+
										getTotalDebito()+getTotalFaturasCredito());
		 
	}
	
	public Double getTotalReal() {
		
		double somaGP =0.0;
		for(GastoPrevisto gp : gastosPrevistos) {
			if(gp.getEstadoPagamento().equals(EstadoPagamento.PAGO.getCod())) { 
				somaGP = somaGP + gp.getValor();
			}
		}
		
		double somaIV =0.0;
		for(Investimento iv : investimentos) {
			if(iv.getEstadoPagamento().equals(EstadoPagamento.PAGO.getCod())) {
				somaIV = somaIV + iv.getValor();
			}	
		}
		
		double somaFC =0.0;
		for(FaturaCredito fc : faturasCredito) {
			if(fc.getEstadoPagamento().equals(EstadoPagamento.PAGO.getCod())) {
				somaFC = somaFC + fc.getTotal();
			}
		}
		
		return getTotalReceitas() - (somaGP+somaIV+getTotalDebito()+somaFC);
		 
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
