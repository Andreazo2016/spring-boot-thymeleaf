package com.devman.demospringthymeleaf.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devman.demospringthymeleaf.model.Funcionario;
import com.devman.demospringthymeleaf.repository.FuncionarioRepository;
import com.devman.demospringthymeleaf.util.DateUtil;
import com.devman.demospringthymeleaf.util.ValidacaoUtil;

@Service
@Transactional(readOnly = false)
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcRepository;

	@Autowired
	private CargoService cargoService;

	public void salvar(Funcionario funcionario) {
		funcRepository.save( funcionario );
	}
	public void update(Funcionario funcionario) {
		funcRepository.save( funcionario );
	}
	public void delete(Long id) {
		funcRepository.deleteById( id );
	}
	@Transactional(readOnly = true)
	public Funcionario findById(Long id) {
		return funcRepository.getOne(id);
	}
	@Transactional(readOnly = true)
	public List<Funcionario> findAll(){
		return funcRepository.findAll();
	}

	public List<Funcionario> buscarPorNome(String nome){
		return funcRepository.findByNomeIgnoreCaseContaining(nome);
	}
	public List<Funcionario> buscarPorCargo( Long idCargo ){
		return cargoService.findById(idCargo).getFuncionarios();
	}
	public List<Funcionario> buscarPorData( LocalDate entrada, LocalDate saida ){
	
		if(ValidacaoUtil.isPreenchido(entrada) && ValidacaoUtil.isPreenchido(saida)) {
			
			return funcRepository.findAllByDataEntradaGreaterThanEqualAndDataSaidaLessThanEqual( entrada, saida );
		}
		if(ValidacaoUtil.isPreenchido(entrada)) {

			return funcRepository.findAllByDataEntradaGreaterThanEqual(entrada);
		}
		if(ValidacaoUtil.isPreenchido(saida)) {
			
			return funcRepository.findAllByDataSaidaLessThanEqual(saida);
		}
		return new ArrayList<Funcionario>();
	}
}
