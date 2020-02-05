package br.com.compasso.gerenciadorPedidos.dao;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import br.com.compasso.gerenciadorPedidos.mapeamento.ProdutosMap;
import br.com.compasso.gerenciadorPedidos.models.Produto;

public class ProdutoDAO extends BaseDAO<ProdutosMap> {

	private static ProdutoDAO instance;

	public ProdutoDAO() throws IOException {
		super(ProdutosMap.class, "produtos.xml");
	}

	public static synchronized ProdutoDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new ProdutoDAO();
		}

		return instance;
	}

	public boolean add(Produto produto) throws IOException {
		return save(getMapping().addProduto(produto));
	}

	public Produto getByCodigo(int codigo) {
		return getMapping().getProdutos().stream().filter(x -> x.getCodigo() == codigo).findFirst().orElse(null);
	}

	public void update() throws IOException {
		save();
	}

	public List<Produto> getAll() {
		return getMapping().getProdutos();
	}

	@Override
	protected ProdutosMap getNewMapping() {
		return new ProdutosMap();
	}
}
