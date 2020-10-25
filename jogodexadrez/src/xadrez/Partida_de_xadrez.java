// Classe fundamental, pois contém todas as regras do jogo de xadrez.
package xadrez;

import tabuleiro.Tabuleiro;

public class Partida_de_xadrez {

	// Uma partida de xadrez contém um tabuleiro:
	private Tabuleiro tabuleiro;
	
	public Partida_de_xadrez()
	{
		tabuleiro= new Tabuleiro(8, 8);
	}
	
	// Método que retorna uma matriz de peças de xadrez para essa essa partida
	
	public Peca_de_xadrez[][] getPieces()
	{
		// Criando uma matriz com quantidade de linhas e colunas do tabuleiro.
		Peca_de_xadrez[][] matriz= new Peca_de_xadrez[tabuleiro.getQddlinhas()][tabuleiro.getQddcolunas()];
		
		// Para cada posição dessa matriz eu vou associar uma peça de xadrez. Para isso, preciso usar o downcasting (Peca_de_xadrez)
		
		for(int i=0; i<tabuleiro.getQddlinhas(); i++)
		{
			for(int j=0; j< tabuleiro.getQddcolunas(); j++)
			{
				matriz[i][j]= (Peca_de_xadrez) tabuleiro.peca(i, j);
			}
		}
		
		return matriz;
		
	}
}
