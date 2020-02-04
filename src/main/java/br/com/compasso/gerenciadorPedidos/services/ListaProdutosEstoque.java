package br.com.compasso.gerenciadorPedidos.services;

import java.io.IOException;
import java.util.Collection;

import br.com.compasso.gerenciadorPedidos.dao.ProdutoDAO;
import br.com.compasso.gerenciadorPedidos.models.Produto;

public class ListaProdutosEstoque {
	
	private ProdutoDAO produtoDAO;
	
	public ListaProdutosEstoque() throws IOException {
		produtoDAO = ProdutoDAO.getInstance();
	}
	
	public void listar() {
		System.out.println("------------------ Estoque ------------------");
		
		Collection<Produto> lista = produtoDAO.getAll();
		
		if(lista.isEmpty()) {
			System.out.println("Estoque Vazio");
		}
		else {
			for (Produto produto : lista) {
				System.out.println(produto);
			}
		}
		
		System.out.println("---------------------------------------------");
	}
	
}
