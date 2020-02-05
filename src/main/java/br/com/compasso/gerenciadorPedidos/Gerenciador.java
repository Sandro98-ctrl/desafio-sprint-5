package br.com.compasso.gerenciadorPedidos;

import java.io.IOException;

import br.com.compasso.gerenciadorPedidos.cadastros.Cadastro;
import br.com.compasso.gerenciadorPedidos.cadastros.ClienteCadastro;
import br.com.compasso.gerenciadorPedidos.cadastros.PedidoCadastro;
import br.com.compasso.gerenciadorPedidos.cadastros.ProdutoCadastro;
import br.com.compasso.gerenciadorPedidos.menus.MenuGerenciador;
import br.com.compasso.gerenciadorPedidos.mostra.MostraProdutosEstoque;
import br.com.compasso.gerenciadorPedidos.services.InputReader;
import br.com.compasso.gerenciadorPedidos.services.Logger;

public class Gerenciador implements Sistema {

	private final Logger logger;
	private final MenuGerenciador menuGerenciador;
	private final InputReader reader;

	public Gerenciador() {
		this.reader = new InputReader();
		this.logger = new Logger();
		this.menuGerenciador = new MenuGerenciador();
	}

	@Override
	public void start() {
		int opcao = 0;
		
		do {
			try {
				menuGerenciador.menu();
				opcao = escolheOpcao(reader.readInt());
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
			reader.close();
			logger.message("Saindo...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			logger.erro("Erro ao sair", e.getMessage());
		}
	}

	private int escolheOpcao(int opcao) throws IOException, NumberFormatException {
		switch (opcao) {
		case 1:
			new MostraProdutosEstoque().mostrar();
			reader.keyUnlock();
			break;
		case 2:
			cadastrar(new PedidoCadastro(reader));
			break;
		case 3:
			cadastrar(new ProdutoCadastro(reader));
			break;
		case 4:
			cadastrar(new ClienteCadastro(reader));
			break;
		default:
			break;
		}
		
		return opcao;
	}

	private void cadastrar(Cadastro cadastro) throws IOException {
		cadastro.cadastrar();
	}
}
