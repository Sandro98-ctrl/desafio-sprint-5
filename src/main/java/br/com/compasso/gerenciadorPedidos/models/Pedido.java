package br.com.compasso.gerenciadorPedidos.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.compasso.gerenciadorPedidos.services.Formatador;

@JacksonXmlRootElement(localName = "pedido")
public class Pedido {

	@JacksonXmlProperty(localName = "codigo")
	private int codigo;
	@JacksonXmlProperty(localName = "cliente")
	private Cliente cliente;
	@JacksonXmlProperty(localName = "produto")
	private Produto produto;
	@JacksonXmlProperty(localName = "quantidade")
	private int quantidade;
	@JacksonXmlProperty(localName = "valor")
	private double valor;

	public Pedido(int codigo, Cliente cliente, Produto produto, int quantidade) throws IllegalArgumentException {
		if (codigo < 1) {
			throw new IllegalArgumentException("Código não pode ser menor que um");
		}

		if (cliente == null) {
			throw new IllegalArgumentException("Cliente não informado");
		}

		if (produto == null) {
			throw new IllegalArgumentException("Produto não informado");
		}

		if (quantidade < 1) {
			throw new IllegalArgumentException("Quantidade não pode ser menor que um");
		}

		this.codigo = codigo;
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	@SuppressWarnings("unused")
	private Pedido() {
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void atualizaValor() {
		this.valor = produto.getPreco() * this.quantidade;
	}

	public void atualizaEstoqueDoProduto() {
		this.produto.atualizaEstoque(quantidade);
	}

	@Override
	public String toString() {
		return String.format("Código: %d, CPF Cliente: %s, Código Produto: %d, Quantidade: %d", codigo,
				Formatador.formatar(new CPFFormatter(), cliente.getCpf()), produto.getCodigo(), quantidade);
	}
}
