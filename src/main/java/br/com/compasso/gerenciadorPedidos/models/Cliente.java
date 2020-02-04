package br.com.compasso.gerenciadorPedidos.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.compasso.gerenciadorPedidos.services.Formatador;
import br.com.compasso.gerenciadorPedidos.services.Validador;

@JacksonXmlRootElement(localName = "cliente")
public class Cliente {

	@JacksonXmlProperty(localName = "cpf")
	private String cpf;
	@JacksonXmlProperty(localName = "nome")
	private String nome;
	@JacksonXmlProperty(localName = "idade")
	private int idade;
	@JacksonXmlProperty(localName = "endereco")
	private String endereco;

	public Cliente(String cpf, String nome, int idade, String endereco) throws IllegalArgumentException {
		if (!Validador.validar(new CPFValidator(), cpf)) {
			throw new IllegalArgumentException("CPF Inválido");
		}

		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome está vazio");
		}

		if (idade < 0 && idade > 150) {
			throw new IllegalArgumentException("Idade inválida");
		}

		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}

	@SuppressWarnings("unused")
	private Cliente() {
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return String.format("CPF: %s, Nome: %s, Idade: %d, Endereço: %s", Formatador.formatar(new CPFFormatter(), cpf),
				nome, idade, endereco);
	}

}
