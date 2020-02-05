package br.com.compasso.gerenciadorPedidos.menus;

public abstract class MenuCadastro {

	private final String titulo;

	public MenuCadastro(String titulo) {
		this.titulo = titulo;
	}

	public void menuPrincipal() {
		System.out.println(titulo);
		System.out.println("## Escolha uma das opções abaixo ##");
		opcoesDoMenu();
		System.out.print(">>> ");
	}

	protected abstract void opcoesDoMenu();
}
