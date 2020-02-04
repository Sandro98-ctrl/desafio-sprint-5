package br.com.compasso.gerenciadorPedidos.menus;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.gerenciadorPedidos.builders.PedidoBuilder;
import br.com.compasso.gerenciadorPedidos.dao.ClienteDAO;
import br.com.compasso.gerenciadorPedidos.models.Cliente;

public class MenuCadastroPedido extends MenuCadastro{

	public MenuCadastroPedido(Scanner sc) {
		super("Cadastro de Pedidos", sc);
	}

	@Override
	protected void opcoesDoMenu() {
		System.out.println("** 1 - Cadastrar Código");
		System.out.println("** 2 - Cadastrar Código do Produto");
		System.out.println("** 3 - Cadastrar CPF do Cliente");
		System.out.println("** 4 - Cadastrar Quantidade");
		System.out.println("** 5 - Cadastrar todos os dados");
		System.out.println("** 6 - Visualizar dados preenchidos");
		System.out.println("** 7 - Salvar Produto");
		System.out.println("** 8 - Voltar");
	}
	
	public void cadastrarCodigo(PedidoBuilder builder) throws NumberFormatException {
		System.out.print("Digite o código do pedido: ");
		builder.addCodigo(Integer.parseInt(readLine()));
	}
	
	public void cadastrarCliente(PedidoBuilder builder) throws IOException {
		System.out.print("Digite o CPF do cliente: ");
		String cpf = readLine();
		ClienteDAO instance = ClienteDAO.getInstance();
		Cliente cliente = instance.getByCpf(cpf);
		
		if(cliente == null) {
			System.err.println("Cliente não encontrado");
		}
		
		builder.addCliente(cliente);
	}
	
	public void cadastrarProduto(PedidoBuilder builder) {
		
	}
	
	public void cadastrarQuantidade(PedidoBuilder builder) throws NumberFormatException {
		System.out.println("Digite a quantidade: ");
		builder.addQuantidade(Integer.parseInt(readLine()));
	}
	
	public void cadastrarTodos(PedidoBuilder builder) throws IOException, NumberFormatException {
		cadastrarCodigo(builder);
		cadastrarProduto(builder);
		cadastrarCliente(builder);
		cadastrarQuantidade(builder);
	}

}
