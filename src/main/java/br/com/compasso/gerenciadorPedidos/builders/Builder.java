package br.com.compasso.gerenciadorPedidos.builders;

public interface Builder<T> {
	T build(); 
	void clear();
}
