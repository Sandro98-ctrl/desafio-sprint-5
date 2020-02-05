package br.com.compasso.gerenciadorPedidos.mostra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.compasso.gerenciadorPedidos.dao.ProdutoDAO;
import br.com.compasso.gerenciadorPedidos.models.Produto;

public class MostraProdutos implements Mostra {

	private ProdutoDAO produtoDAO;

	public MostraProdutos() throws IOException {
		this.produtoDAO = ProdutoDAO.getInstance();
	}

	@Override
	public void mostrar() {
		System.out.println("------------------ Produtos Cadastrados ------------------");
		List<Produto> lista = new ArrayList<Produto>(produtoDAO.getAll());
		
		if (lista.isEmpty()) {
			System.out.println("Não há produtos cadastrados");
		} else {
			lista.sort(Comparator.comparing(Produto::getDescricao));
			lista.forEach(System.out::println);
		}

		System.out.println("---------------------------------------------------------");
	}
}
