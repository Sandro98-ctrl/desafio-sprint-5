package br.com.compasso.gerenciadorPedidos.services;

public class Logger {
	
	public void message(String titulo, String msg) {
		System.out.println(buildMessage(titulo, msg));
	}
	
	public void message(String msg) {
		System.out.println(buildMessage(null, msg));
	}

	public void erro(String titulo, String erro) {
		System.err.println(buildMessage(titulo, erro));
	}
	
	public void erro(String erro) {
		System.err.println(buildMessage(null, erro));
	}
	
	private String buildMessage(String titulo, String msg) {
		if(titulo == null || titulo.isEmpty()) {
			return String.format(">> %s <<", msg);
		}
		
		return String.format(">> %s: %s <<", titulo, msg);
	}

}
