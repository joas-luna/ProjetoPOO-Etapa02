package br.com.example.validadores;

import br.com.example.excecoes.InstanciacaoException;


public final class Data {
	private Data() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar ");
	}

    public static String validarData(String data) {
        return data;
    }
}
