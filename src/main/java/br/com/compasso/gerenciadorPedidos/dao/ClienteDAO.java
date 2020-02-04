package br.com.compasso.gerenciadorPedidos.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.compasso.gerenciadorPedidos.mapeamento.ClientesMap;
import br.com.compasso.gerenciadorPedidos.models.Cliente;

public class ClienteDAO extends BaseDAO<ClientesMap> {

	private static ClienteDAO instance;

	private ClienteDAO() throws IOException {
		super(ClientesMap.class, "clientes.xml");
	}

	public static synchronized ClienteDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new ClienteDAO();
		}

		return instance;
	}

	public boolean add(Cliente cliente) throws IOException {
		return save(mapping.addCliente(cliente));
	}

	public Cliente getByCpf(String cpf) {
		return mapping.getClientes()
				.stream()
				.filter(x -> x.getCpf() == cpf)
				.findFirst()
				.orElse(null);
	}
	
	@Override
	protected ClientesMap getNewMapping() {
		return new ClientesMap();
	}

}
