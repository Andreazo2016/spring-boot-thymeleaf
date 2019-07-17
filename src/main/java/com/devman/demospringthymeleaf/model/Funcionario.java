package com.devman.demospringthymeleaf.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="funcionario")
public class Funcionario  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Informe o nome do funcionário")
	@Column(name = "nome_funcionario",nullable = false)
	private String nome;
	
	@NotNull(message = "Deve informar um valor para o salário")
	@NumberFormat(style = Style.CURRENCY,pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;
	
	
	@DateTimeFormat(iso = ISO.DATE )
	@Column(name="data_entrada", columnDefinition = "DATE",nullable = false)
	private LocalDate dataEntrada;
	
	@DateTimeFormat(iso = ISO.DATE )
	@Column(name="data_saida", columnDefinition = "DATE")
	private LocalDate dataSaida;
	
	
	@NotNull(message = "Selecione  endereco")
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="id_endereco_fk")
	private @Valid Endereco endereco;
	
	
	@NotNull(message = "Deve informar um cargo para o funcionario")
	@ManyToOne
	@JoinColumn(name="id_cargo_fk")
	private Cargo cargo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
