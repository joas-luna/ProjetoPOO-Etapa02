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
			return sc.nextLine().strip();
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
	
	public static String confirmar(String string, Integer coluna) {
		if(string.equals("")) {
			Saida.linhaAnterior();
			Saida.coluna(coluna);
			Saida.limparDireitaLinha();
			System.out.print(Saida.vermelho("\t\t\t\t\tCancelar operação?\r\u001B[%dG").formatted(coluna));

			string = input();
		}

		 return string;
	}

	public static String confirmar(Integer coluna) {
		Saida.linhaAnterior();
		Saida.coluna(coluna);
		Saida.limparDireitaLinha();
		System.out.print(Saida.vermelho("\t\t\t\t\tCancelar operação?\r\u001B[%dG").formatted(coluna));

		return input();
	}

	public static String confirmar(Integer coluna, Integer tabulacoes) {
		Saida.linhaAnterior();
		Saida.coluna(coluna);
		Saida.limparDireitaLinha();
		System.out.print(Saida.vermelho(Saida.tabulacoes(tabulacoes) + "Cancelar operação?\r\u001B[%dG").formatted(coluna));

		String string = input();

		return string;
	}

	public static String confirmar(String string, String message, Integer coluna) {
		if(string.equals("")) {
			Saida.linhaAnterior();
			Saida.coluna(coluna);
			Saida.limparDireitaLinha();
			System.out.print(message + Saida.vermelho("\t\t\t\t\tCancelar operação?\r\u001B[%dG").formatted(coluna));

			string = input();
		}

		 return string;
	}

	public static String confirmar(String string, String message, Integer coluna, Integer tabulacoes) {
		if(string.equals("")) {
			Saida.linhaAnterior();
			Saida.coluna(coluna);
			Saida.limparDireitaLinha();
			System.out.print(message + Saida.vermelho(Saida.tabulacoes(tabulacoes) + "Cancelar operação?\r\u001B[%dG").formatted(coluna));

			string = input();
		}

		 return string;
	}

	public static String confirmar(String string, Integer coluna, Integer tabulacoes) {
		if(string.equals("")) {
			Saida.linhaAnterior();
			Saida.coluna(coluna);
			Saida.limparDireitaLinha();
			System.out.print(Saida.vermelho(Saida.tabulacoes(tabulacoes) + "Cancelar operação?\r\u001B[%dG").formatted(coluna));

			string = input();
		}

		 return string;
	}
}
