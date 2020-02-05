package br.com.compasso.gerenciador_pedidos.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import br.com.compasso.gerenciadorPedidos.mapeamento.ProdutosMap;
import br.com.compasso.gerenciadorPedidos.models.Produto;
import br.com.compasso.gerenciadorPedidos.services.Serializador;

class ProdutosMapTest {

	@Test
	void seriazeTest() {
		
//		try {
//			String name = "produtos.xml";
//			ProdutosMap map = new ProdutosMap();
//			//map.serialize(name, map);
//			
//			assertTrue(new File(name).exists());
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	@Test
	void deseriazeTest() throws IOException {
		
		String name = "produtos.xml";
		ProdutosMap map = new ProdutosMap();
		//map.addProduto(new Produto("P1", 21, 23.9));
		//map.addProduto(new Produto("P2", 21, 23.9));
		//map.addProduto(new Produto("P3", 21, 23.9));
		
		//Serializador<ProdutosMap> serializador = new Serializador<ProdutosMap>(ProdutosMap.class);
		//serializador.serialize(name, map);
		
		assertTrue(new File(name).exists());
		
	}

}
