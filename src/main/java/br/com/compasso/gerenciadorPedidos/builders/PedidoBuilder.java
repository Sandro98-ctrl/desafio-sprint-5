package br.com.compasso.gerenciadorPedidos.builders;

import br.com.compasso.gerenciadorPedidos.models.Cliente;
import br.com.compasso.gerenciadorPedidos.models.Pedido;
import br.com.compasso.gerenciadorPedidos.models.Produto;

public class PedidoBuilder implements Builder<Pedido>{
	
	private int codigo;
	private Produto produto;
	private Cliente cliente;
	private int quantidade;
	
	public PedidoBuilder addCodigo(int codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public PedidoBuilder addProduto(Produto produto) {
		this.produto = produto;
		return this;
	}
	
	public PedidoBuilder addCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public PedidoBuilder addQuantidade(int quantidade) {
		this.quantidade = quantidade;
		return this;
	}
	
	@Override
	public String toString() {
		return new StringBuffer()
				.append("Código: " + codigo)
				.append(System.lineSeparator())
				.append("Produto: " + produto)
				.append(System.lineSeparator())
				.append("Cliente: " + cliente)
				.append(System.lineSeparator())
				.append("Quantidade: " + quantidade)
				.toString();
	}

	@Override
	public Pedido build() {
		return new Pedido(codigo, cliente, produto, quantidade);
	}
	
	@Override
	public void clear() {
		codigo = 0;
		cliente = null;
		produto = null;
		quantidade = 0;
	}
}
