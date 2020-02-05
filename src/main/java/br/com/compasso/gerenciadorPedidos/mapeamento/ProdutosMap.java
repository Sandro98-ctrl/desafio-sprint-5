package br.com.compasso.gerenciadorPedidos.mapeamento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.gerenciadorPedidos.models.Produto;

@JacksonXmlRootElement(localName = "produtos")
public class ProdutosMap {

	@JacksonXmlProperty(localName = "produto")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Produto> produtos;

	public ProdutosMap() {
		this.produtos = new ArrayList<Produto>();
	}
	
	public boolean addProduto(Produto produto) {
		return produtos.add(produto);
	}
	
//	public boolean addProdutos(List<Produto> produtos) {
//		return this.produtos.addAll(produtos);
//	}
	
	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}
}
