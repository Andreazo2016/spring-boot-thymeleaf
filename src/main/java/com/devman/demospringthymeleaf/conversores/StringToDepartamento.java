package com.devman.demospringthymeleaf.conversores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devman.demospringthymeleaf.model.Departamento;
import com.devman.demospringthymeleaf.service.DepartamentoService;
import com.devman.demospringthymeleaf.util.ValidacaoUtil;

@Component
public class StringToDepartamento implements Converter<String, Departamento> {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Override
	public Departamento convert(String idDepartamento) {
		if(ValidacaoUtil.isPreenchido(idDepartamento)) {
			return departamentoService.findById(Long.valueOf( idDepartamento ) );
		}
		return null;
	}

}
