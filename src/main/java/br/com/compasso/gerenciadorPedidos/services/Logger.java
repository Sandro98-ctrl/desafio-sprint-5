package br.com.compasso.gerenciadorPedidos.services;

public class Logger {
	
	public void message(String titulo, String msg) {
		//String border = buildBorder(msg);
		//System.out.println(border);
		System.out.println(buildMessage(titulo, msg));
		//System.out.println(border);
	}

	public void erro(String titulo, String erro) {
		//String border = buildBorder(erro);
		//System.err.println(border);
		System.err.println(buildMessage(titulo, erro));
		//System.err.println(border);
	}
	
	private String buildMessage(String titulo, String msg) {
		if(titulo == null || titulo.isEmpty()) {
			return String.format(">> %s <<", msg);
		}
		
		return String.format(">> %s: %s <<", titulo, msg);
	}

	/*
	 * private String buildBorder(String msg) { StringBuilder sb = new
	 * StringBuilder();
	 * 
	 * for (int i = 0; i < msg.length(); i++) { sb.append('='); }
	 * 
	 * return sb.toString(); }
	 */
}
