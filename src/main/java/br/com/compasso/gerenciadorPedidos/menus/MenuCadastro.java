package br.com.compasso.gerenciadorPedidos.menus;

import java.util.Scanner;

public abstract class MenuCadastro {

	private final String titulo;
	private final Scanner scanner;

	public MenuCadastro(String titulo, Scanner sc) {
		this.titulo = titulo;
		this.scanner = sc;
	}

	public void menuPrincipal() {
		System.out.println(titulo);
		System.out.println("## Escolha uma das opções abaixo ##");
		opcoesDoMenu();
	}

	public int readIntegerInput() throws NumberFormatException {
		System.out.print(">>> ");
		return Integer.parseInt(readLine());
	}
	
	public String readLine() {
		return scanner.nextLine();
	}
	
	public void keyBlock() {
		String algo = null;
		System.out.println("Tecle Enter para voltar...");
		
		while(algo == null) {
			algo = readLine();
		}
	}

	protected abstract void opcoesDoMenu();
}
