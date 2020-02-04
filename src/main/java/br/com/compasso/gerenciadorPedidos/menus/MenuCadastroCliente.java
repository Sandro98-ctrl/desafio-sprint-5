package br.com.compasso.gerenciadorPedidos.menus;

import java.util.Scanner;

import br.com.compasso.gerenciadorPedidos.builders.ClienteBuilder;

public class MenuCadastroCliente extends MenuCadastro {

	public MenuCadastroCliente(Scanner sc) {
		super("Cadastro de Clientes", sc);
	}

	@Override
	protected void opcoesDoMenu() {
		System.out.println("** 1 - Cadastrar CPF");
		System.out.println("** 2 - Cadastrar Nome");
		System.out.println("** 3 - Cadastrar Idade");
		System.out.println("** 4 - Cadastrar Endereço");
		System.out.println("** 5 - Cadastrar todos os dados");
		System.out.println("** 6 - Visualizar dados preenchidos");
		System.out.println("** 7 - Salvar Cliente");
		System.out.println("** 8 - Voltar");
	}

	public void cadastrarCpf(ClienteBuilder builder) throws NumberFormatException {
		System.out.print("Digite o CPF: ");
		builder.addCpf(readLine());
	}

	public void cadastrarNome(ClienteBuilder builder) {
		System.out.print("Digite o nome: ");
		builder.addNome(readLine());
	}

	public void cadastrarIdade(ClienteBuilder builder) throws NumberFormatException {
		System.out.print("Digite a idade: ");
		builder.addIdade(Integer.parseInt(readLine()));
	}

	public void cadastrarEndereco(ClienteBuilder builder) {
		System.out.print("Digite o endereço: ");
		builder.addEndereco(readLine());
	}

	public void cadastrarTodos(ClienteBuilder builder) throws NumberFormatException {
		cadastrarCpf(builder);
		cadastrarNome(builder);
		cadastrarIdade(builder);
		cadastrarEndereco(builder);
	}
}
