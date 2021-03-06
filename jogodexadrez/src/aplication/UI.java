//Classe que cont�m m�todo para imprimir os resultados na tela
package aplication;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.Cor;
import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_de_xadrez;

public class UI {

	// Ser� respons�vel pela cor das pe�as quando o terminal de sa�da for o GIT
	// BASH. (c�digo copiado)
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

	// M�todo que limpa o tabuleiro anterior. C�digo de https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
	 System.out.print("\033[H\033[2J");
	 System.out.flush();
	} 
	
	
	// m�todo que permite a entrada da posi��o pelo usu�rio
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
			throw new InputMismatchException("Voc� so pode entrar com valores de a1 at� h8");
		}
		
	}
	
	// m�todo que imprime tabuleiro
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

	// m�todo que imprime uma pe�a
	public static void printPeca(Peca_de_xadrez pecadexadrez, boolean colorir_ou_nao) {
		// se n�o tiver pe�a em uma posi��o do tabuleiro, imprimimos um tra�o

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
		// imprimindo espa�o em branco para que as pe�as n�o fiquem grudadas
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

	//M�todo que imprime a partida de xadrez, contendo o turno e uma mensagem de espera; e n�o somente o tabuleiro
	public static void printPartida(Partida_de_xadrez partida, List<Peca_de_xadrez> pecascapturadas)
	{
		//Imprime o tabuleiro
		printTabuleiro(partida.getPieces());
		System.out.println();
		imprimepecascapturadas(pecascapturadas);
		System.out.println("Turno: " + partida.getTurno());
		System.out.println("Esperando a jogada do: " + partida.getCor_da_vez());
		
		if(partida.getXeque() == true)
		{
			System.out.println("O rei est� em xeque!");
		}
	}
	
	//M�todo que imprime na tela as pe�as capturadas durante o jogo. Para isso, precisamos criar antes uma lista dessas pe�as
	private static void imprimepecascapturadas(List<Peca_de_xadrez> pecascapturadas)
	{
		//Dessa lista de pe�as capturadas, precisamos separar as brancas das pretas. Para isso, usamos express�es lambda.
		List<Peca_de_xadrez> brancascapturadas= pecascapturadas.stream().filter(x -> x.getCor() == Cor.BRANCO).collect(Collectors.toList());
		List<Peca_de_xadrez> pretascapturadas= pecascapturadas.stream().filter(y -> y.getCor() == Cor.PRETO).collect(Collectors.toList());
		
		System.out.println("Pe�as capturadas: ");
		System.out.print("Pe�as brancas: ");
		
		System.out.print(ANSI_WHITE);
		System.out.print(brancascapturadas);
		System.out.print(ANSI_RESET);
		System.out.println();
		
		System.out.print("Pe�as pretas: ");
		System.out.print(ANSI_YELLOW);
		System.out.print(pretascapturadas);
		System.out.println(ANSI_RESET);
	}
}
