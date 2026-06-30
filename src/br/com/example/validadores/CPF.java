package br.com.example.validadores;

import br.com.example.excecoes.InstanciacaoException;


public final class CPF {
	private CPF() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar CPF");
	}
    
	public static String validarCPF(String cpf) {
		return cpf;
	}
}
