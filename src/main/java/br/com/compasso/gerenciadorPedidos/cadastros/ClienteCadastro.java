package br.com.compasso.gerenciadorPedidos.cadastros;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.gerenciadorPedidos.builders.ClienteBuilder;
import br.com.compasso.gerenciadorPedidos.dao.ClienteDAO;
import br.com.compasso.gerenciadorPedidos.menus.MenuCadastroCliente;

public class ClienteCadastro implements Cadastro {

	private final ClienteDAO clienteDAO;
	private final ClienteBuilder builder;
	private final MenuCadastroCliente menuCadastro;

	public ClienteCadastro(Scanner sc) throws IOException {
		clienteDAO = ClienteDAO.getInstance();
		builder = new ClienteBuilder();
		menuCadastro = new MenuCadastroCliente(sc);
	}

	@Override
	public void cadastrar() throws IOException {
		int opcao = 0;

		do {
			menuCadastro.menuPrincipal();
			opcao = escolherOpcao(menuCadastro.readIntegerInput());
		} while (opcao != 8);
	}

	private int escolherOpcao(int opcao) throws IOException, NumberFormatException {
		switch (opcao) {
		case 1:
			menuCadastro.cadastrarCpf(builder);
			break;
		case 2:
			menuCadastro.cadastrarNome(builder);
			break;
		case 3:
			menuCadastro.cadastrarIdade(builder);
			break;
		case 4:
			menuCadastro.cadastrarEndereco(builder);
			break;
		case 5:
			menuCadastro.cadastrarTodos(builder);
			break;
		case 6:
			System.out.println(builder);
			menuCadastro.keyBlock();
			break;
		case 7:
			clienteDAO.add(builder.build());
			builder.clear();
			break;
		}

		return opcao;
	}

}
