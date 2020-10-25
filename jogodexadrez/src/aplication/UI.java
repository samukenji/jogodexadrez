//Classe que cont�m m�todo para imprimir o tabuleiro de xadrez
package aplication;

import xadrez.Peca_de_xadrez;

public class UI {
	
	// m�todo que imprime tabuleiro
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
	
	// m�todo que imprime uma pe�a
	public static void printPeca(Peca_de_xadrez pecadexadrez)
	{
		// se n�o tiver pe�a em uma posi��o do tabuleiro, imprimimos um tra�o
		if(pecadexadrez==null)
		{
			System.out.print("-");
		}
		else {
			System.out.print(pecadexadrez);
		}
		// imprimindo espa�o em branco para que as pe�as n�o fiquem grudadas
		System.out.print(" ");
	}
	
}
