package br.com.compasso.gerenciadorPedidos.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "produto")
public class Produto {

	@JacksonXmlProperty(localName = "codigo")
	private int codigo;
	@JacksonXmlProperty(localName = "descricao")
	private String descricao;
	@JacksonXmlProperty(localName = "estoque")
	private int estoque;
	@JacksonXmlProperty(localName = "preco")
	private double preco;

	public Produto(int codigo, String descricao, int estoque, double preco) throws IllegalArgumentException {
		if (codigo < 1) {
			throw new IllegalArgumentException("Código não pode ser menor que um");
		}

		if (descricao == null || descricao.isEmpty()) {
			throw new IllegalArgumentException("Descrição está vazia");
		}

		if (estoque < 1) {
			throw new IllegalArgumentException("Quantidade não pode ser menor que um");
		}

		this.codigo = codigo;
		this.descricao = descricao;
		this.estoque = estoque;
		this.preco = preco;
	}

	@SuppressWarnings("unused")
	private Produto() {
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getEstoque() {
		return estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void atualizaEstoque(int estoque) {
		if (this.estoque < estoque) {
			throw new IllegalArgumentException("Estoque insuficiente");
		}

		this.estoque -= estoque;
	}

	@Override
	public String toString() {
		return String.format("Código: %d, Descrição: %s, Estoque: %d, Preço: R$%.2f", codigo, descricao, estoque,
				preco);
	}
}
