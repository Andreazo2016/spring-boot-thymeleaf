package com.devman.demospringthymeleaf.conversores;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String , Integer> {

	@Override
	public Integer convert(String source) {
		String texto = source.trim();
		if(texto.matches("[0-9]+")) {
			return Integer.valueOf( source );
		}
		return null;
	}

}
