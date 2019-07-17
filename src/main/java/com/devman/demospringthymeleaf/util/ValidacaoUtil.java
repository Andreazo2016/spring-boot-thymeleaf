package com.devman.demospringthymeleaf.util;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;


public class ValidacaoUtil {
	
public static boolean isPreenchido(Object valor) {
		
		if (valor != null) {
			if (valor instanceof Collection<?>) {
				return ((Collection<?>)valor).size() > Constantes.INDICE_INICIAL;
			} else if (valor instanceof String) {
				return StringUtils.isNotEmpty(String.valueOf(valor)); 
			} else if (valor instanceof Serializable){
				return valor.equals(valor);
			} else if (valor instanceof Integer) {
				return (valor != null && (Integer) valor > 0); 
			}
			
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}

}
