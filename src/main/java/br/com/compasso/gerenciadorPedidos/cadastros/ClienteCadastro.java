package br.com.compasso.gerenciadorPedidos.cadastros;

import java.io.IOException;

import br.com.compasso.gerenciadorPedidos.builders.ClienteBuilder;
import br.com.compasso.gerenciadorPedidos.dao.ClienteDAO;
import br.com.compasso.gerenciadorPedidos.menus.MenuCadastroCliente;
import br.com.compasso.gerenciadorPedidos.mostra.Mostra;
import br.com.compasso.gerenciadorPedidos.mostra.MostraClientes;
import br.com.compasso.gerenciadorPedidos.services.InputReader;

public class ClienteCadastro implements Cadastro {

	private final ClienteDAO clienteDAO;
	private final ClienteBuilder builder;
	private final MenuCadastroCliente menuCadastro;
	private final InputReader reader;
	private final Mostra mostra;

	public ClienteCadastro(InputReader reader) throws IOException {
		this.reader = reader;
		this.clienteDAO = ClienteDAO.getInstance();
		this.builder = new ClienteBuilder();
		this.menuCadastro = new MenuCadastroCliente();
		this.mostra = new MostraClientes();
	}

	@Override
	public void cadastrar() throws IOException {
		int opcao = 0;

		do {
			menuCadastro.menuPrincipal();
			opcao = escolherOpcao(reader.readInt());
		} while (opcao != 9);
	}

	private int escolherOpcao(int opcao) throws IOException, NumberFormatException {
		switch (opcao) {
		case 1:
			cadastrarCpf();
			break;
		case 2:
			cadastrarNome();
			break;
		case 3:
			cadastrarIdade();
			break;
		case 4:
			cadastrarEndereco();
			break;
		case 5:
			cadastrarCpf();
			cadastrarNome();
			cadastrarIdade();
			cadastrarEndereco();
			break;
		case 6:
			System.out.println(builder);
			reader.keyUnlock();
			break;
		case 7:
			mostra.mostrar();
			reader.keyUnlock();
			break;
		case 8:
			clienteDAO.add(builder.build());
			builder.clear();
			break;
		}

		return opcao;
	}

	private void cadastrarCpf() {
		System.out.print("Digite o CPF: ");
		builder.addCpf(reader.readLine());
	}

	private void cadastrarNome() {
		System.out.print("Digite o nome: ");
		builder.addNome(reader.readLine());
	}

	private void cadastrarIdade() throws NumberFormatException {
		System.out.print("Digite a idade: ");
		builder.addIdade(reader.readInt());
	}

	private void cadastrarEndereco() {
		System.out.print("Digite o endereço: ");
		builder.addEndereco(reader.readLine());
	}

}
