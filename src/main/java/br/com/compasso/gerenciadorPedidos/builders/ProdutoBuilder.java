package br.com.compasso.gerenciadorPedidos.builders;

import br.com.compasso.gerenciadorPedidos.models.Produto;

public class ProdutoBuilder implements Builder<Produto> {

	private int codigo;
	private String descricao;
	private int estoque;
	private double preco;

	public ProdutoBuilder() {
		descricao = "";
	}

	public ProdutoBuilder addCodigo(int codigo) {
		this.codigo = codigo;
		return this;
	}

	public ProdutoBuilder addDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public ProdutoBuilder addEstoque(int estoque) {
		this.estoque = estoque;
		return this;
	}

	public ProdutoBuilder addPreco(double preco) {
		this.preco = preco;
		return this;
	}

	@Override
	public Produto build() {
		return new Produto(codigo, descricao, estoque, preco);
	}

	@Override
	public void clear() {
		codigo = 0;
		descricao = "";
		estoque = 0;
		preco = 0.0;
	}

	@Override
	public String toString() {
		return new StringBuffer()
				.append("C�digo: " + codigo)
				.append(System.lineSeparator())
				.append("Descri��o: " + descricao)
				.append(System.lineSeparator())
				.append("Estoque: " + estoque)
				.append(System.lineSeparator())
				.append(String.format("Pre�o: %.2f", preco))
				.toString();
	}
}
