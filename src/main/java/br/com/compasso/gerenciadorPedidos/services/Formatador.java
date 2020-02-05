package br.com.compasso.gerenciadorPedidos.services;

import br.com.caelum.stella.format.Formatter;

public class Formatador {

	public static String formatar(Formatter formatador, String input) {
		return formatador.canBeFormatted(input) ? formatador.format(input) : input;
	}
}
