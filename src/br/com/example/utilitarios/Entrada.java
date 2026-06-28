package br.com.example.utilitarios;

import br.com.example.excecoes.InstanciacaoException;

public final class Entrada {
	private Entrada() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar ");
	}
    
	public static String removerEspacos(String string) {
		return string.replace(" ", "");
	}

	public static boolean isInteger(String string) {
		return string.matches("^[+-]?\\d+$");
	}
}
