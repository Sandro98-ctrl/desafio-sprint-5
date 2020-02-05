package br.com.compasso.gerenciadorPedidos.mapeamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.gerenciadorPedidos.models.Pedido;

@JacksonXmlRootElement(localName = "pedidos")
public class PedidosMap {

	@JacksonXmlProperty(localName = "pedido")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Pedido> pedidos;

	public PedidosMap() {
		pedidos = new ArrayList<Pedido>();
	}

	public boolean addPedido(Pedido pedido) {
		return pedidos.add(pedido);
	}

	public List<Pedido> getPedidos() {
		return Collections.unmodifiableList(pedidos);
	}
}
