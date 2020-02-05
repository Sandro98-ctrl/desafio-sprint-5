package br.com.compasso.gerenciadorPedidos.services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Serializador {

	public <T> void serialize(String fileName, T obj) throws IOException {
		ObjectMapper mapper = new XmlMapper();
		mapper.writeValue(new File(fileName), obj);
	}

	public <T> T deserialize(String fileName, Class<T> classe) throws IOException {
		ObjectMapper mapper = new XmlMapper();
		return mapper.readValue(new File(fileName), classe);
	}

}
