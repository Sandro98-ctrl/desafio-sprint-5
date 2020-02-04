package br.com.compasso.gerenciadorPedidos.dao;

import java.io.File;
import java.io.IOException;

import br.com.compasso.gerenciadorPedidos.services.Serializador;

public abstract class BaseDAO<T> {

	protected final T mapping;
	private final String fileName;
	private final Serializador<T> serializador;

	public BaseDAO(Class<T> classe, String filename) throws IOException {
		this.serializador = new Serializador<T>(classe);
		this.fileName = filename;
		this.mapping = getInstance();
	}
	
	protected boolean save(boolean salvar) throws IOException {
		if(salvar) {
			save();
		}
		
		return salvar;
	}

	protected void save() throws IOException {
		serializador.serialize(fileName, mapping);
	}

	private T getInstance() throws IOException {
		if (new File(fileName).exists()) {
			return serializador.deserialize(fileName);
		}

		return getNewMapping();
	}
	
	protected abstract T getNewMapping();
}
