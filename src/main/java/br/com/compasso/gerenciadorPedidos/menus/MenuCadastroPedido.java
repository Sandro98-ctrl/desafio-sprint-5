package br.com.compasso.gerenciadorPedidos.menus;

public class MenuCadastroPedido extends MenuCadastro {

	public MenuCadastroPedido() {
		super("Cadastro de Pedidos");
	}

	@Override
	protected void opcoesDoMenu() {
		System.out.println("** 1 - Cadastrar Código");
		System.out.println("** 2 - Cadastrar CPF do Cliente");
		System.out.println("** 3 - Cadastrar Código do Produto");
		System.out.println("** 4 - Cadastrar Quantidade");
		System.out.println("** 5 - Cadastrar todos os dados");
		System.out.println("** 6 - Visualizar dados preenchidos");
		System.out.println("** 7 - Visualizar pedidos realizados");
		System.out.println("** 8 - Visualizar clientes cadastrados");
		System.out.println("** 9 - Visualizar produtos cadastrados");
		System.out.println("** 10 - Salvar Produto");
		System.out.println("** 11 - Voltar");
	}

}
