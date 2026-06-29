package br.com.example.utilitarios;

import br.com.example.excecoes.InstanciacaoException;

public final class Saida {
	private Saida() throws InstanciacaoException {
		throw new InstanciacaoException("Não pode instanciar Saida");
	}

	public static String tabulacoes(int quantidade) {
		if(quantidade < 0) {
			return "";
		}

		String tabulacoes = "";

		for(int i = 0; i < quantidade; i++) tabulacoes += "\t";

		return tabulacoes;
	}

	public static void campo(String message, String error, int tabulacoes) {
		sobrescreverLinhaAtual(message + tabulacoes(tabulacoes) + vermelho(error));
		coluna(message.length() + 1);
	}

	public static void campo(String error, int tabulacoes, int coluna) {
		sobrescreverLinhaAtual(tabulacoes(tabulacoes) + vermelho(error));
		coluna(coluna);
	}

	public static void sobrescreverLinhaAtual(String message) {
		System.out.print("\r\u001B[2K");
	}

	public static String vermelho(String string) {
		return "\u001B[31;1m" + string + "\u001B[m";
	}

	public static String roxo(String string) {
		return "\u001B[34;1m" + string + "\u001B[m";
	}
    
	public static String verde(String string) {
		return "\u001B[32;1m" + string + "\u001B[m";
	}

	public static String amarelo(String string) {
		return "\u001B[33;1m" + string + "\u001B[m";
	}
	
	public static String ciano(String string) {
		return "\u001B[36;1m" + string + "\u001B[m";
	}
	
	public static void limparLinhaAtual() {
		System.out.print("\u001B[2K");
	}
	
	public static void linhaAnterior() {
		System.out.print("\u001B[F");
	}
	
	public static void limparLinhaAnterior() {
		linhaAnterior();
		limparLinhaAtual();
	}

	public static void sobrescreverLinhaAnterior(String msg) {
		limparLinhaAnterior();
		System.out.print(msg);
	}

	public static void limparDireitaLinha() {
		System.out.print("\u001B[K");
	}

	public static void coluna(int coluna) {
		System.out.printf("\u001B[%dG", coluna);
	}

	public static void limparTerminal() {
		System.out.print("\u001B[H\u001B[2J\u001B[3J");
	}
}
