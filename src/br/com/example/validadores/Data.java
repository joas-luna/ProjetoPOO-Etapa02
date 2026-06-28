package br.com.example.validadores;

import java.util.Scanner;

import br.com.example.excecoes.InstanciacaoException;

public final class Data {
	private Data() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar ");
	}

    public static String validarData(String data, Scanner input) {
        return data;
    }
}
