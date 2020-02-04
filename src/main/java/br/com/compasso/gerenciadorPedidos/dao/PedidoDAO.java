package br.com.compasso.gerenciadorPedidos.dao;

import java.io.IOException;

import br.com.compasso.gerenciadorPedidos.mapeamento.PedidosMap;
import br.com.compasso.gerenciadorPedidos.models.Pedido;

public class PedidoDAO extends BaseDAO<PedidosMap> {

	private static PedidoDAO instance;

	private PedidoDAO() throws IOException {
		super(PedidosMap.class, "pedidos.xml");
	}

	public static synchronized PedidoDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new PedidoDAO();
		}

		return instance;
	}

	public boolean add(Pedido pedido) throws IOException {
		return save(mapping.addPedido(pedido));
	}

	@Override
	protected PedidosMap getNewMapping() {
		return new PedidosMap();
	}

}
