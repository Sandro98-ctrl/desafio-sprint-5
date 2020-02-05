package br.com.compasso.gerenciadorPedidos.mostra;

import java.io.IOException;
import java.util.List;

import br.com.compasso.gerenciadorPedidos.dao.PedidoDAO;
import br.com.compasso.gerenciadorPedidos.models.Pedido;

public class MostraPedidos implements Mostra {

	private PedidoDAO pedidoDao;

	public MostraPedidos() throws IOException {
		this.pedidoDao = PedidoDAO.getInstance();
	}

	@Override
	public void mostrar() {
		System.out.println("------------------ Pedidos Realizados ------------------");
		List<Pedido> lista = pedidoDao.getAll();

		if (lista.isEmpty()) {
			System.out.println("Não há pedidos realizados");
		} else {
			lista.forEach(System.out::println);
		}

		System.out.println("--------------------------------------------------------");
	}

}
