//Classe que contém método para imprimir o tabuleiro de xadrez
package aplication;

import xadrez.Peca_de_xadrez;

public class UI {
	
	// método que imprime tabuleiro
	public static void printTabuleiro(Peca_de_xadrez[][] tabuleirodexadrez)
	{
		for(int i=0; i<tabuleirodexadrez.length; i++)
		{
			System.out.print((8-i)+ " ");
			for(int j=0; j<tabuleirodexadrez.length; j++)
			{
				printPeca(tabuleirodexadrez[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");		
	}
	
	// método que imprime uma peça
	public static void printPeca(Peca_de_xadrez pecadexadrez)
	{
		// se não tiver peça em uma posição do tabuleiro, imprimimos um traço
		if(pecadexadrez==null)
		{
			System.out.print("-");
		}
		else {
			System.out.print(pecadexadrez);
		}
		// imprimindo espaço em branco para que as peças não fiquem grudadas
		System.out.print(" ");
	}
	
}
