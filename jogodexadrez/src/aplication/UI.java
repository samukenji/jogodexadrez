//Classe que contém método para imprimir o tabuleiro de xadrez e permitir entrada de dados
package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Cor;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_de_xadrez;

public class UI {

	// Será responsável pela cor das peças quando o terminal de saída for o GIT
	// BASH. (código copiado)
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// Método que limpa o tabuleiro anterior. Código de https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
	 System.out.print("\033[H\033[2J");
	 System.out.flush();
	} 
	
	
	// método que permite a entrada da posição pelo usuário
	public static  Posicao_de_xadrez entradadeposicao(Scanner entrar)
	{
		try {
		String s= entrar.next();
		char coluna= s.charAt(0);
		int linha = Integer.parseInt(s.substring(1));
		return new Posicao_de_xadrez(coluna, linha);

		}
		catch(RuntimeException e)
		{
			throw new InputMismatchException("Você so pode entrar com valores de a1 até h8");
		}
		
	}
	
	// método que imprime tabuleiro
	public static void printTabuleiro(Peca_de_xadrez[][] tabuleirodexadrez) {
		for (int i = 0; i < tabuleirodexadrez.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < tabuleirodexadrez.length; j++) {
				printPeca(tabuleirodexadrez[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	// método que imprime uma peça
	public static void printPeca(Peca_de_xadrez pecadexadrez, boolean colorir_ou_nao) {
		// se não tiver peça em uma posição do tabuleiro, imprimimos um traço

		if(colorir_ou_nao)
		{
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (pecadexadrez == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (pecadexadrez.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_WHITE + pecadexadrez + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + pecadexadrez + ANSI_RESET);
			}
		}
		// imprimindo espaço em branco para que as peças não fiquem grudadas
		System.out.print(" ");
		
	}
	
	public static void printTabuleiro(Peca_de_xadrez[][] tabuleirodexadrez, boolean[][] movimentosquedaprafazer) {
		for (int i = 0; i < tabuleirodexadrez.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < tabuleirodexadrez.length; j++) {
				printPeca(tabuleirodexadrez[i][j], movimentosquedaprafazer[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

}
