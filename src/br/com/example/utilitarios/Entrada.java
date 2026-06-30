package br.com.example.utilitarios;

import java.util.NoSuchElementException;
import java.util.Scanner;

import br.com.example.excecoes.InstanciacaoException;

public final class Entrada {
    public static final Scanner sc = new Scanner(System.in);

	private Entrada() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar Entrada.");
	}
    
	public static String removerEspacos(String string) {
		return string.replace(" ", "");
	}

	public static boolean isInteger (String string) {
		return string.matches("^[+-]?\\d+$");
	}

	public static String input() {
		try {
			return sc.nextLine();
		} catch(NoSuchElementException e) {
			return "";
		}
	}

	public static String input(String message) {
		try {
			System.out.print(message);
			return sc.nextLine();
		} catch(NoSuchElementException e) {
			return "";
		}
	}

	public static Integer  integerInput() {
		try {
			return Integer.parseInt(input());
		} catch(NumberFormatException e) {
			return null;
		}
	}

	public static Integer  integerInput(String message) {
		try {
			return Integer.parseInt(input(message));
		} catch(NumberFormatException e) {
			return null;
		}
	}

	public static String confirmar(String string, Integer coluna) {
		if(string.equals("")) {
			Saida.linhaAnterior();
			Saida.coluna(coluna);
			Saida.limparDireitaLinha();
			System.out.print(Saida.vermelho("\t\t\tCancelar operação?\r\u001B[%dG").formatted(coluna));

			string = input();
		}

		 return string;
	}

	public static String confirmar(String string, String message, Integer coluna) {
		if(string.equals("")) {
			Saida.linhaAnterior();
			Saida.coluna(coluna);
			Saida.limparDireitaLinha();
			System.out.print(message + Saida.vermelho("\t\t\tCancelar operação?\r\u001B[%dG").formatted(coluna));

			string = input();
		}

		 return string;
	}
}
