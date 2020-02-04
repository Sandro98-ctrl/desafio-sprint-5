package br.com.compasso.gerenciadorPedidos.mapeamento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.compasso.gerenciadorPedidos.models.Cliente;

@JacksonXmlRootElement(localName = "clientes")
public class ClientesMap {
	
	@JacksonXmlProperty(localName = "cliente")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Collection<Cliente> clientes;
	
	public ClientesMap() {
		clientes = new ArrayList<Cliente>();
	}
	
	public boolean addCliente(Cliente cliente) {
		return clientes.add(cliente);
	}
	
	public Collection<Cliente> getClientes() {
		return Collections.unmodifiableCollection(clientes);
	}
}
