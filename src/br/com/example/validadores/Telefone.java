package br.com.example.validadores;

import br.com.example.excecoes.InstanciacaoException;

public final class Telefone {
	private Telefone() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar ");
	}

	public static String validarTelefone(String tel) {
		return tel;
	}
}
