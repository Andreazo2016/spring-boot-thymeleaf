package com.devman.demospringthymeleaf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo logradouro deve ser informado")
	@Column(nullable = false)
	private String logradouro;
	
	@NotBlank(message = "O campo bairro deve ser informado")
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank(message = "O campo cidade deve ser informado")
	@Column(nullable = false)
	private String cidade;
	
	@NotNull(message = "O campo uf deve ser informado")
	@Column(nullable = false, length = 2)
	@Enumerated( EnumType.STRING )
	private UF uf;
	
	
	@NotBlank(message = "O campo cep deve ser informado")
	@Column(nullable = false, length = 9)
	private String cep;
	
	@NotNull(message = "O campo numero deve ser informado")
	@Column(nullable = false)
	private Integer numero;
	
	private String complemento;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
	
}
