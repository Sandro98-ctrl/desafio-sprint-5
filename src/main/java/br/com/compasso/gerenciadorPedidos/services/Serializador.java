package br.com.compasso.gerenciadorPedidos.services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Serializador<T> {

	private Class<T> classe;

	public Serializador(Class<T> classe) {
		this.classe = classe;
	}

	public void serialize(String fileName, T obj) throws IOException {
		ObjectMapper mapper = new XmlMapper();
		mapper.writeValue(new File(fileName), obj);
	}

	public T deserialize(String fileName) throws IOException {
		ObjectMapper mapper = new XmlMapper();
		return mapper.readValue(new File(fileName), classe);
	}

}
