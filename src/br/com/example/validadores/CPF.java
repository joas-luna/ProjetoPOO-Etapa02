package br.com.example.validadores;

import br.com.example.excecoes.InstanciacaoException;
import br.com.example.utilitarios.Entrada;
import br.com.example.utilitarios.Saida;


public final class CPF {
	private CPF() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar CPF");
	}
    
	private static boolean cpfInvalido(String cpf) {
		return !limparFormatacao(cpf).matches("\\d{11}");
	}

	private static String limparFormatacao(String cpf) {
		return cpf.replaceAll("[\\.\\-_, ]", "");
	}

	private static String formatarCPF(String cpf) {
		if(cpfInvalido(cpf)) {
			return "";
		}

		String[] cpfSplited = limparFormatacao(cpf).split("");
		cpfSplited[2] += ".";
		cpfSplited[5] += ".";
		cpfSplited[8] += "-";

		return String.join("", cpfSplited);
	}

	public static String validarCPF(String cpf) {
		if(cpf.equals("")) {
			cpf = Entrada.confirmar(6);
		}

		while(cpfInvalido(cpf)) {
			if(cpf.equals("")) {
				break;
			}
			
			Saida.linhaAnterior();
			Saida.campo("CPF: ", "CPF inválido!", 5);
			cpf = Entrada.confirmar(Entrada.input(), 6);
		}

		Saida.linhaAnterior(40);
		Saida.limparDireitaLinha();
		System.out.print("\n");

		return formatarCPF(cpf);
	}
}
