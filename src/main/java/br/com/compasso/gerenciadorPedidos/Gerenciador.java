package br.com.compasso.gerenciadorPedidos;

import java.io.IOException;
import java.util.Scanner;

import br.com.compasso.gerenciadorPedidos.cadastros.Cadastro;
import br.com.compasso.gerenciadorPedidos.cadastros.ClienteCadastro;
import br.com.compasso.gerenciadorPedidos.cadastros.PedidoCadastro;
import br.com.compasso.gerenciadorPedidos.cadastros.ProdutoCadastro;
import br.com.compasso.gerenciadorPedidos.services.ListaProdutosEstoque;
import br.com.compasso.gerenciadorPedidos.services.Logger;
import br.com.compasso.gerenciadorPedidos.services.Menu;

public class Gerenciador implements Sistema {

	private int opcao;
	private final Scanner scanner;
	private final Logger logger;
	private Menu menu;

	public Gerenciador() {
		this.scanner = new Scanner(System.in);
		this.logger = new Logger();
		this.menu = new Menu();
	}

	@Override
	public void start() {
		do {
			try {
				menuPrincipal();
				switchOpcoes();
			} catch (NumberFormatException e) {
				logger.erro("Formato Inválido", "Digite um número no formato correto");
			} catch (IOException e) {
				logger.erro("Algo deu errado", e.getMessage());
			}
		} while (opcao != 5);

		stop();
	}

	@Override
	public void stop() {
		try {
			scanner.close();
			logger.message(null, "Saindo...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			logger.erro("Erro ao sair", e.getMessage());
		}
	}

	private void menuPrincipal() throws NumberFormatException {
		System.out.println("## Escolha uma das opções abaixo ##");
		System.out.println("** 1 - Verificar Estoque");
		System.out.println("** 2 - Realizar Pedido");
		System.out.println("** 3 - Cadastrar Produto");
		System.out.println("** 4 - Cadastrar Cliente");
		System.out.println("** 5 - Sair");
		System.out.print(">>> ");
		opcao = Integer.parseInt(scanner.nextLine());
	}

	private void switchOpcoes() throws IOException, NumberFormatException {
		switch (opcao) {
		case 1:
			new ListaProdutosEstoque().listar();
			break;
		case 2:
			cadastrar(new PedidoCadastro(scanner));
			break;
		case 3:
			cadastrar(new ProdutoCadastro(scanner));
			break;
		case 4:
			cadastrar(new ClienteCadastro(scanner));
			break;
		default:
//			if (opcao < 1 && opcao > 5) {
//				logger.message(null, "Operação Inválida");
//			}
			break;
		}
	}

	private void cadastrar(Cadastro cadastro) throws IOException {
		cadastro.cadastrar();
	}
}
