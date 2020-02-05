package br.com.compasso.gerenciadorPedidos.mostra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.compasso.gerenciadorPedidos.dao.ClienteDAO;
import br.com.compasso.gerenciadorPedidos.models.Cliente;

public class MostraClientes implements Mostra {

	private ClienteDAO clienteDao;

	public MostraClientes() throws IOException {
		this.clienteDao = ClienteDAO.getInstance();
	}

	@Override
	public void mostrar() {
		System.out.println("------------------ Clientes Cadastrados ------------------");
		List<Cliente> lista = new ArrayList<Cliente>(clienteDao.getAll());
		
		if (lista.isEmpty()) {
			System.out.println("Não há clientes cadastrados");
		} else {
			lista.sort(Comparator.comparing(Cliente::getNome));
			lista.forEach(System.out::println);
		}

		System.out.println("----------------------------------------------------------");
	}

}
