package br.com.compasso.gerenciadorPedidos.menus;

public class MenuCadastroCliente extends MenuCadastro {

	public MenuCadastroCliente() {
		super("Cadastro de Clientes");
	}

	@Override
	protected void opcoesDoMenu() {
		System.out.println("** 1 - Cadastrar CPF");
		System.out.println("** 2 - Cadastrar Nome");
		System.out.println("** 3 - Cadastrar Idade");
		System.out.println("** 4 - Cadastrar Endereço");
		System.out.println("** 5 - Cadastrar todos os dados");
		System.out.println("** 6 - Visualizar dados preenchidos");
		System.out.println("** 7 - Visualizar clientes cadastrados");
		System.out.println("** 8 - Salvar Cliente");
		System.out.println("** 9 - Voltar");
	}
}
