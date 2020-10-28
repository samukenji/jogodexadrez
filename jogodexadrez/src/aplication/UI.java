//Classe que contém método para imprimir o tabuleiro de xadrez
package aplication;

import xadrez.Cor;
import xadrez.Peca_de_xadrez;

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

	// método que imprime tabuleiro
	public static void printTabuleiro(Peca_de_xadrez[][] tabuleirodexadrez) {
		for (int i = 0; i < tabuleirodexadrez.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < tabuleirodexadrez.length; j++) {
				printPeca(tabuleirodexadrez[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	// método que imprime uma peça
	public static void printPeca(Peca_de_xadrez pecadexadrez) {
		// se não tiver peça em uma posição do tabuleiro, imprimimos um traço

		if (pecadexadrez == null) {
			System.out.print("-");
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

}
