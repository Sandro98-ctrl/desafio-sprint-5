package br.com.compasso.gerenciadorPedidos.cadastros;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.gerenciadorPedidos.builders.ProdutoBuilder;
import br.com.compasso.gerenciadorPedidos.dao.ProdutoDAO;
import br.com.compasso.gerenciadorPedidos.menus.MenuCadastroProduto;

public class ProdutoCadastro implements Cadastro {

	private final ProdutoDAO produtoDAO;
	private final ProdutoBuilder builder;
	private final MenuCadastroProduto menuCadastro;

	public ProdutoCadastro(Scanner sc) throws IOException {
		this.menuCadastro = new MenuCadastroProduto(sc);
		this.produtoDAO = ProdutoDAO.getInstance();
		this.builder = new ProdutoBuilder();
	}

	@Override
	public void cadastrar() throws IOException, NumberFormatException {
		int opcao = 0;

		do {
			menuCadastro.menuPrincipal();
			opcao = escolheOpcao(menuCadastro.readIntegerInput());
		} while (opcao != 8);
	}

	private int escolheOpcao(int opcao) throws IOException, NumberFormatException {
		switch (opcao) {
		case 1:
			menuCadastro.cadastrarCodigo(builder);
			break;
		case 2:
			menuCadastro.cadastrarDescricao(builder);
			break;
		case 3:
			menuCadastro.cadastrarEstoque(builder);
			break;
		case 4:
			menuCadastro.cadastrarPreco(builder);
			break;
		case 5:
			menuCadastro.cadastrarTodos(builder);
			break;
		case 6:
			System.out.println(builder);
			menuCadastro.keyBlock();
			break;
		case 7:
			produtoDAO.add(builder.build());
			builder.clear();
			break;
		}

		return opcao;
	}
}
