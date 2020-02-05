package br.com.compasso.gerenciadorPedidos.cadastros;

import java.io.IOException;

import br.com.compasso.gerenciadorPedidos.builders.PedidoBuilder;
import br.com.compasso.gerenciadorPedidos.dao.ClienteDAO;
import br.com.compasso.gerenciadorPedidos.dao.PedidoDAO;
import br.com.compasso.gerenciadorPedidos.dao.ProdutoDAO;
import br.com.compasso.gerenciadorPedidos.menus.MenuCadastroPedido;
import br.com.compasso.gerenciadorPedidos.models.Cliente;
import br.com.compasso.gerenciadorPedidos.models.Pedido;
import br.com.compasso.gerenciadorPedidos.models.Produto;
import br.com.compasso.gerenciadorPedidos.mostra.Mostra;
import br.com.compasso.gerenciadorPedidos.mostra.MostraClientes;
import br.com.compasso.gerenciadorPedidos.mostra.MostraPedidos;
import br.com.compasso.gerenciadorPedidos.mostra.MostraProdutos;
import br.com.compasso.gerenciadorPedidos.services.InputReader;
import br.com.compasso.gerenciadorPedidos.services.Logger;

public class PedidoCadastro implements Cadastro {

	private final PedidoDAO pedidoDAO;
	private final ProdutoDAO produtoDAO;
	private final ClienteDAO clienteDAO;
	private final PedidoBuilder builder;
	private final MenuCadastroPedido menuCadastro;
	private final InputReader reader;
	private final Logger logger;

	public PedidoCadastro(InputReader reader) throws IOException {
		this.reader = reader;
		this.pedidoDAO = PedidoDAO.getInstance();
		this.produtoDAO = ProdutoDAO.getInstance();
		this.clienteDAO = ClienteDAO.getInstance();
		this.menuCadastro = new MenuCadastroPedido();
		this.builder = new PedidoBuilder();
		this.logger = new Logger();
	}

	@Override
	public void cadastrar() throws IOException {
		int opcao = 0;

		do {
			menuCadastro.menuPrincipal();
			opcao = escolheOpcao(reader.readInt());
		} while (opcao != 11);
	}

	private int escolheOpcao(int opcao) throws IOException, NumberFormatException {
		switch (opcao) {
		case 1:
			cadastrarCodigo();
			break;
		case 2:
			cadastrarCliente();
			break;
		case 3:
			cadastrarProduto();
			break;
		case 4:
			cadastrarQuantidade();
			break;
		case 5:
			cadastrarCodigo();
			cadastrarCliente();
			cadastrarProduto();
			cadastrarQuantidade();
			break;
		case 6:
			System.out.println(builder);
			reader.keyUnlock();
			break;
		case 7:
			Mostrar(new MostraPedidos());
			reader.keyUnlock();
			break;
		case 8:
			Mostrar(new MostraClientes());
			reader.keyUnlock();
			break;
		case 9:
			Mostrar(new MostraProdutos());
			reader.keyUnlock();
			break;
		case 10:
			realizarPedido();
			break;
		}

		return opcao;
	}
	
	private void realizarPedido() throws IllegalArgumentException, IOException {
		Pedido pedido = builder.build();
		pedido.atualizarEstoqueDoProduto();
		Produto produto = pedido.getProduto();
		produtoDAO.update(produto);
		pedidoDAO.add(pedido);
		builder.clear();
	}

	private void cadastrarCodigo() throws NumberFormatException {
		System.out.print("Digite o código do pedido: ");
		builder.addCodigo(reader.readInt());
	}

	private void cadastrarCliente() throws IOException {
		System.out.print("Digite o CPF do cliente: ");
		String cpf = reader.readLine();
		Cliente cliente = clienteDAO.getByCpf(cpf);

		if (cliente == null) {
			logger.erro("Cliente não encontrado");
		}

		builder.addCliente(cliente);
	}

	private void cadastrarProduto() throws NumberFormatException {
		System.out.print("Digite o código do produto: ");
		int codigo = reader.readInt();
		Produto produto = produtoDAO.getByCodigo(codigo);

		if (produto == null) {
			logger.erro("Produto não encontrado");
			return;
		}
		
		if(produto.getEstoque() < 1) {
			logger.erro("Produto sem estoque");
			return;
		}

		builder.addProduto(produto);
	}

	private void cadastrarQuantidade() throws NumberFormatException {
		System.out.println("Digite a quantidade: ");
		builder.addQuantidade(reader.readInt());
	}
	
	private void Mostrar(Mostra mostra) {
		mostra.mostrar();
	}

}
