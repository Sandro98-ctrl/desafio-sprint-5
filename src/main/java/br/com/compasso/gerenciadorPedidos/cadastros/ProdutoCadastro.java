package br.com.compasso.gerenciadorPedidos.cadastros;

import java.io.IOException;

import br.com.compasso.gerenciadorPedidos.builders.ProdutoBuilder;
import br.com.compasso.gerenciadorPedidos.dao.ProdutoDAO;
import br.com.compasso.gerenciadorPedidos.menus.MenuCadastroProduto;
import br.com.compasso.gerenciadorPedidos.mostra.Mostra;
import br.com.compasso.gerenciadorPedidos.mostra.MostraProdutos;
import br.com.compasso.gerenciadorPedidos.services.InputReader;

public class ProdutoCadastro implements Cadastro {

	private final ProdutoDAO produtoDAO;
	private final ProdutoBuilder builder;
	private final MenuCadastroProduto menuCadastro;
	private final InputReader reader;
	private final Mostra mostra;

	public ProdutoCadastro(InputReader reader) throws IOException {
		this.menuCadastro = new MenuCadastroProduto();
		this.produtoDAO = ProdutoDAO.getInstance();
		this.builder = new ProdutoBuilder();
		this.reader = reader;
		this.mostra = new MostraProdutos();
	}

	@Override
	public void cadastrar() throws IOException, NumberFormatException {
		int opcao = 0;

		do {
			menuCadastro.menuPrincipal();
			opcao = escolheOpcao(reader.readInt());
		} while (opcao != 9);
	}

	private int escolheOpcao(int opcao) throws IOException, NumberFormatException {
		switch (opcao) {
		case 1:
			cadastrarCodigo();
			break;
		case 2:
			cadastrarDescricao();
			break;
		case 3:
			cadastrarEstoque();
			break;
		case 4:
			cadastrarPreco();
			break;
		case 5:
			cadastrarCodigo();
			cadastrarDescricao();
			cadastrarEstoque();
			cadastrarPreco();
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
			produtoDAO.add(builder.build());
			builder.clear();
			break;
		}

		return opcao;
	}

	private void cadastrarCodigo() throws NumberFormatException {
		System.out.print("Digite o código do produto: ");
		builder.addCodigo(reader.readInt());
	}

	private void cadastrarDescricao() {
		System.out.print("Digite a descrição: ");
		builder.addDescricao(reader.readLine());
	}

	private void cadastrarEstoque() throws NumberFormatException {
		System.out.print("Digite o estoque: ");
		builder.addEstoque(reader.readInt());
	}

	private void cadastrarPreco() throws NumberFormatException {
		System.out.print("Digite o preço: ");
		builder.addPreco(reader.readDouble());
	}
}
