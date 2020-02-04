package br.com.compasso.gerenciadorPedidos.builders;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.compasso.gerenciadorPedidos.models.Cliente;
import br.com.compasso.gerenciadorPedidos.services.Formatador;

public class ClienteBuilder implements Builder<Cliente> {

	private String cpf;
	private String nome;
	private int idade;
	private String endereco;

	public ClienteBuilder() {
		cpf = 
		nome = 
		endereco = "";
	}

	public ClienteBuilder addCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public ClienteBuilder addNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ClienteBuilder addIdade(int idade) {
		this.idade = idade;
		return this;
	}

	public ClienteBuilder addEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	@Override
	public Cliente build() {
		return new Cliente(cpf, nome, idade, endereco);
	}

	@Override
	public void clear() {
		cpf =
		nome = 
		endereco = "";
		idade = 0;
	}
	
	@Override
	public String toString() {
		return new StringBuffer()
				.append("CPF: " + Formatador.formatar(new CPFFormatter(), cpf))
				.append(System.lineSeparator())
				.append("Nome: " + nome)
				.append(System.lineSeparator())
				.append("Idade: " + idade)
				.append(System.lineSeparator())
				.append("Endereço: " + endereco)
				.toString();
	}

}
