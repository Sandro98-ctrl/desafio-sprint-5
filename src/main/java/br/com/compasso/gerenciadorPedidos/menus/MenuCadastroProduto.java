package br.com.compasso.gerenciadorPedidos.menus;

import java.util.Scanner;

import br.com.compasso.gerenciadorPedidos.builders.ProdutoBuilder;

public class MenuCadastroProduto extends MenuCadastro {

	public MenuCadastroProduto(Scanner scanner) {
		super("Cadastro de Produtos", scanner);
	}

	@Override
	protected void opcoesDoMenu() {
		System.out.println("** 1 - Cadastrar C�digo");
		System.out.println("** 2 - Cadastrar Descri��o");
		System.out.println("** 3 - Cadastrar Quantidade");
		System.out.println("** 4 - Cadastrar Pre�o");
		System.out.println("** 5 - Cadastrar todos os dados");
		System.out.println("** 6 - Visualizar dados preenchidos");
		System.out.println("** 7 - Salvar Produto");
		System.out.println("** 8 - Voltar");
	}
	
	public void cadastrarCodigo(ProdutoBuilder builder) throws NumberFormatException {
		System.out.print("Digite o c�digo do produto: ");
		builder.addCodigo(Integer.parseInt(readLine()));
	}

	public void cadastrarDescricao(ProdutoBuilder builder) {
		System.out.print("Digite a descri��o: ");
		builder.addDescricao(readLine());
	}

	public void cadastrarEstoque(ProdutoBuilder builder) throws NumberFormatException {
		System.out.print("Digite o estoque: ");
		builder.addEstoque(Integer.parseInt(readLine()));
	}

	public void cadastrarPreco(ProdutoBuilder builder) throws NumberFormatException {
		System.out.print("Digite o pre�o: ");
		builder.addPreco(Double.parseDouble(readLine()));
	}

	public void cadastrarTodos(ProdutoBuilder builder) throws NumberFormatException {
		cadastrarCodigo(builder);
		cadastrarDescricao(builder);
		cadastrarEstoque(builder);
		cadastrarPreco(builder);
	}
}
