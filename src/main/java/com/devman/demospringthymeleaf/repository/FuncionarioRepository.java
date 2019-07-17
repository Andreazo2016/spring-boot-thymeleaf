package com.devman.demospringthymeleaf.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devman.demospringthymeleaf.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	List<Funcionario> findAllByDataEntradaGreaterThanEqualAndDataSaidaLessThanEqual(LocalDate entrada, LocalDate saida);
	List<Funcionario> findAllByDataEntradaGreaterThanEqual(LocalDate entrada);
	List<Funcionario> findAllByDataSaidaLessThanEqual(LocalDate saida);
	List<Funcionario> findByNomeIgnoreCaseContaining(String nome);
}
