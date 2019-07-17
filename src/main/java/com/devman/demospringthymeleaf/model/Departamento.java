package com.devman.demospringthymeleaf.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="departamento")
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Informe o nome do departamento")
	@Size(min = 3, max = 60, message = "O nome do departamento deve ter entre {min} e {max} de caracteres")
	@Column(name="nome_departamento", nullable = false, length = 60)
	private String nomeDepartamento;

	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	
	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nomeDepartamento=" + nomeDepartamento + "]";
	}
	
	
	
	
}
