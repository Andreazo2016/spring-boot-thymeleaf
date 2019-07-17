package com.devman.demospringthymeleaf.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devman.demospringthymeleaf.model.Departamento;
import com.devman.demospringthymeleaf.repository.DepartamentoRepository;
import com.devman.demospringthymeleaf.util.ValidacaoUtil;

@Service
@Transactional(readOnly = false)
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository deparRepository;
	
	public void salvar(Departamento departamento) {
		deparRepository.save( departamento );
	}
	public void update(Departamento departamento) {
		deparRepository.save( departamento );
	}
	public void delete( Long id ) {
		deparRepository.deleteById( id );
	}
	@Transactional(readOnly = true)
	public Departamento findById(Long id) {
		return deparRepository.getOne(id);
	}
	@Transactional(readOnly = true)
	public List<Departamento> findAll(){
		return deparRepository.findAll();
	}
	
	public boolean podeDeletar( Long idDepartamento ) {
		Departamento departamento = findById(idDepartamento);
		if(ValidacaoUtil.isPreenchido(departamento) && departamento.getCargos().isEmpty()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
