package br.com.compasso.gerenciadorPedidos.dao;

import java.io.File;
import java.io.IOException;

import br.com.compasso.gerenciadorPedidos.services.Serializador;

public abstract class BaseDAO<T> {

	private T mapping;
	private final Class<T> classe;
	private final String fileName;
	private final Serializador serializador;

	public BaseDAO(Class<T> classe, String filename) throws IOException {
		this.classe = classe;
		this.serializador = new Serializador();
		this.fileName = filename;
		this.mapping = getInstance();
	}
	
	protected T getMapping() {
		return mapping;
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
	
	protected void update(T mapping) throws IOException {
		this.mapping = mapping;
		save();
	}

	private T getInstance() throws IOException {
		if (new File(fileName).exists()) {
			return (T) serializador.deserialize(fileName, classe);
		}

		return getNewMapping();
	}
	
	protected abstract T getNewMapping();
}
