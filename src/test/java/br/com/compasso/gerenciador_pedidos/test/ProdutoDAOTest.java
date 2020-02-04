package br.com.compasso.gerenciador_pedidos.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import br.com.compasso.gerenciadorPedidos.dao.ProdutoDAO;
import br.com.compasso.gerenciadorPedidos.models.Produto;

class ProdutoDAOTest {

	@Test
	void testandoEscritaLeituraXml() {

		try {
			ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
			produtoDAO.add(new Produto(1, "P1", 32, 45.9));
			produtoDAO.add(new Produto(2, "P2", 32, 45.9));
			produtoDAO.add(new Produto(3, "P3", 32, 45.9));

			assertTrue(new File("produtos.xml").exists());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
