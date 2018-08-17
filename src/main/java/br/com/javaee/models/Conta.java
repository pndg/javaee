package br.com.javaee.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String dataLancamento;
	
	@NotNull
	private Integer tipoLancamento;
	
	@NotBlank
	private String nome;
	
	@NotNull
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
