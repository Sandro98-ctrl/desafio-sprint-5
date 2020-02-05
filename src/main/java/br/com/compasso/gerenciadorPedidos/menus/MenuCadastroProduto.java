package br.com.compasso.gerenciadorPedidos.menus;

public class MenuCadastroProduto extends MenuCadastro {

	public MenuCadastroProduto() {
		super("Cadastro de Produtos");
	}

	@Override
	protected void opcoesDoMenu() {
		System.out.println("** 1 - Cadastrar Código");
		System.out.println("** 2 - Cadastrar Descrição");
		System.out.println("** 3 - Cadastrar Quantidade");
		System.out.println("** 4 - Cadastrar Preço");
		System.out.println("** 5 - Cadastrar todos os dados");
		System.out.println("** 6 - Visualizar dados preenchidos");
		System.out.println("** 7 - Visualizar produtos cadastrados");
		System.out.println("** 8 - Salvar Produto");
		System.out.println("** 9 - Voltar");
	}
}
