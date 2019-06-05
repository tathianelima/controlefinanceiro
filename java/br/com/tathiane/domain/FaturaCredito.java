package br.com.tathiane.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.tathiane.domain.enums.EstadoPagamento;

@Entity
public class FaturaCredito  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date mes;
	
	private Integer estadoPagamento;
	
	
	@OneToMany(mappedBy="fatura")
	private List<Credito> compras = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="conta_id")
	private ContaGeral contaGeral;
	
	public FaturaCredito() {
	}

	public FaturaCredito(Integer id, Date mes, EstadoPagamento estadoPagamento, ContaGeral contaGeral) {
		super();
		this.id = id;
		this.mes = mes;
		this.estadoPagamento = estadoPagamento.getCod();
		this.contaGeral = contaGeral;
	}
	
	public Double getTotal() {
		double soma =0.0;
		for(Credito cd : compras) {
			soma = soma + cd.getValor();
		}
		return soma;
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

	public Integer getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}
	
	public List<Credito> getCompras() {
		return compras;
	}

	public void setCompras(List<Credito> compras) {
		this.compras = compras;
	}

	public ContaGeral getContaGeral() {
		return contaGeral;
	}

	public void setContaGeral(ContaGeral contaGeral) {
		this.contaGeral = contaGeral;
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
		FaturaCredito other = (FaturaCredito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
