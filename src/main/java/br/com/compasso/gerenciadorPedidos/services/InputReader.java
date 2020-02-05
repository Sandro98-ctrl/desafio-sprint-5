package br.com.compasso.gerenciadorPedidos.services;

import java.io.Closeable;
import java.util.Scanner;

public class InputReader implements Closeable {

	private Scanner scanner;

	public InputReader() {
		scanner = new Scanner(System.in);
	}

	public String readLine() {
		return scanner.nextLine();
	}

	public int readInt() throws NumberFormatException {
		return Integer.parseInt(readLine());
	}

	public double readDouble() throws NumberFormatException {
		return Double.parseDouble(readLine());
	}

	public void keyUnlock() {
		System.out.print("Tecle Enter para voltar...");
		String key;
		while ((key = readLine()) == null) {
		}
	}

	@Override
	public void close() {
		scanner.close();
	}
}
