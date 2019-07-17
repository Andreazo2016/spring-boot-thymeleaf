package com.devman.demospringthymeleaf.conversores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devman.demospringthymeleaf.model.Cargo;
import com.devman.demospringthymeleaf.service.CargoService;
import com.devman.demospringthymeleaf.util.ValidacaoUtil;

@Component
public class StringToCargo implements Converter<String, Cargo> {
	
	@Autowired
	private CargoService cargoService;
	
	@Override
	public Cargo convert(String idCargo) {
		
		if(ValidacaoUtil.isPreenchido(idCargo)) {
			return cargoService.findById(Long.valueOf(idCargo));
		}
		return null;
	}

}
