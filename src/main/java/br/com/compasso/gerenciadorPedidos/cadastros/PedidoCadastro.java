package br.com.compasso.gerenciadorPedidos.cadastros;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.gerenciadorPedidos.builders.PedidoBuilder;
import br.com.compasso.gerenciadorPedidos.dao.PedidoDAO;
import br.com.compasso.gerenciadorPedidos.menus.MenuCadastroPedido;

public class PedidoCadastro implements Cadastro {

	private final PedidoDAO pedidoDAO;
	private final PedidoBuilder builder;
	private final MenuCadastroPedido menuCadastro;

	public PedidoCadastro(Scanner sc) throws IOException {
		this.menuCadastro = new MenuCadastroPedido(sc);
		this.pedidoDAO = PedidoDAO.getInstance();
		this.builder = new PedidoBuilder();
	}

	@Override
	public void cadastrar() throws IOException {
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

			break;
		case 3:

			break;
		case 4:
			menuCadastro.cadastrarQuantidade(builder);
			break;
		case 5:
			menuCadastro.cadastrarTodos(builder);
			break;
		case 6:
			System.out.println(builder);
			menuCadastro.keyBlock();
			break;
		case 7:
			pedidoDAO.add(builder.build());
			builder.clear();
			break;
		}

		return opcao;
	}

}
