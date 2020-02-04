package br.com.compasso.gerenciadorPedidos.services;

import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;

public class Validador {

	public static <T> boolean validar(Validator<T> validador, T input) {
		if(!validador.isEligible(input)) {
			return false;
		}
		
		try {
			validador.assertValid(input);
			return true;
		}
		catch (InvalidStateException e) {
			return false;
		}
	}
}
