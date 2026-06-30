package br.com.example.validadores;

import br.com.example.excecoes.InstanciacaoException;
import br.com.example.utilitarios.Entrada;
import br.com.example.utilitarios.Saida;

public final class Nome {
	private Nome() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar ");
	}

	private static boolean nomeInvalido(String nome) {
		return !nome.strip().matches("^[\\p{L} ]+$");
	}
    
	public static String validarNome(String nome) {
		if(nome.equals("")) {
			nome = Entrada.confirmar(7);
		}

		while(nomeInvalido(nome)) {
			if(nome.equals("")) {
				break;
			}
			
			Saida.linhaAnterior();
			Saida.campo("Nome: ", "Nome inválido!", 5);
			nome = Entrada.confirmar(Entrada.input(), 7);
		}

		Saida.linhaAnterior(40);
		Saida.limparDireitaLinha();
		System.out.print("\n");

		return nome.strip();
	}
}
