package br.com.example.validadores;

import br.com.example.excecoes.InstanciacaoException;

public final class Nome {
	private Nome() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar ");
	}
    
	public static String validarNome(String nome) {
		return nome;
	}
}
