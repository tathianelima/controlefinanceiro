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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FaturaDebito implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private Date mes;

	@OneToMany(mappedBy="fatura")
	private List<MovimentoDebito> compras = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="conta_id")
	private ContaGeral contaGeral;
	
	public FaturaDebito() {
	}


	public FaturaDebito(Integer id, Date mes, ContaGeral contaGeral) {
		super();
		this.id = id;
		this.mes = mes;
		this.contaGeral = contaGeral;
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
	
	public List<MovimentoDebito> getCompras() {
		return compras;
	}


	public void setCompras(List<MovimentoDebito> compras) {
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
		FaturaDebito other = (FaturaDebito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
