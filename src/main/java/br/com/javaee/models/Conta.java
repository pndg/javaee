package br.com.javaee.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Override
	public String toString() {
		return "Conta [id=" + id + ", dataLancamento=" + dataLancamento + ", tipoLancamento=" + tipoLancamento
				+ ", nome=" + nome + ", valor=" + valor + "]";
	}

	private String dataLancamento;
	
	private Integer tipoLancamento;
	
	private String nome;
	
	private Double valor;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(Integer tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	
	
	
	
	
	
	
	
	
	
	

}