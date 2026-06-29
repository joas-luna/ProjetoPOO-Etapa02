package br.com.example.utilitarios;

import java.util.NoSuchElementException;
import java.util.Scanner;

import br.com.example.excecoes.InstanciacaoException;

public final class Entrada {
    public static final Scanner sc = new Scanner(System.in);

	private Entrada() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar ");
	}
    
	public static String removerEspacos(String string) {
		return string.replace(" ", "");
	}

	public static boolean isInteger(String string) {
		return string.matches("^[+-]?\\d+$");
	}

	public static String confirmar(String string, String message, Scanner input) {
		if(string.equals("")) {
			System.out.print(message + Saida.vermelho("\t\t\tCancelar operação?"));
			Saida.coluna(message.length() + 1);
			
			try {
				string = input.nextLine();
			} catch(NoSuchElementException e) {
				return "";
			}
		}

		return string;
	}
}
