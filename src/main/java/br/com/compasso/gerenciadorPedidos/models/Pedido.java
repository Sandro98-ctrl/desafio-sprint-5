package br.com.compasso.gerenciadorPedidos.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "pedido")
public class Pedido {
	
	@JacksonXmlProperty(localName = "codigo")
	private int codigo;
	private Cliente cliente;
	private Produto produto;
	@JacksonXmlProperty(localName = "quantidade")
	private int quantidade;
	
	public Pedido(int codigo, Cliente cliente, Produto produto, int quantidade) throws IllegalArgumentException{
		if(codigo < 1) {
			throw new IllegalArgumentException("Código não pode ser menor que um");
		}
		
		if(cliente == null)	{
			throw new IllegalArgumentException("Cliente não informado");
		}
		
		if(produto == null) {
			throw new IllegalArgumentException("Produto não informado");
		}
		
		if(quantidade < 1) {
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
}
