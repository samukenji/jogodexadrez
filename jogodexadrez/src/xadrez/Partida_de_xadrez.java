// Classe fundamental, pois cont�m todas as regras do jogo de xadrez.
package xadrez;

import pecas_oficiais.Torre;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Partida_de_xadrez {

	// Uma partida de xadrez cont�m um tabuleiro:
	private Tabuleiro tabuleiro;
	
	// O tabuleiro de xadrez cont�m sempre 8 linhas e 8 colunas
	public Partida_de_xadrez()
	{
		tabuleiro= new Tabuleiro(8, 8);
		iniciodejogo();
	}
	
	// M�todo que retorna uma matriz de pe�as de xadrez para essa essa partida
	
	public Peca_de_xadrez[][] getPieces()
	{
		// Criando uma matriz com quantidade de linhas e colunas do tabuleiro.
		Peca_de_xadrez[][] matriz= new Peca_de_xadrez[tabuleiro.getQddlinhas()][tabuleiro.getQddcolunas()];
		
		// Para cada posi��o dessa matriz eu vou associar uma pe�a de xadrez. Para isso, preciso usar o downcasting (Peca_de_xadrez)
		
		for(int i=0; i<tabuleiro.getQddlinhas(); i++)
		{
			for(int j=0; j< tabuleiro.getQddcolunas(); j++)
			{
				matriz[i][j]= (Peca_de_xadrez) tabuleiro.peca(i, j);
			}
		}
		
		return matriz;	
	}
	
	//M�todo respons�vel por iniciar a partida de xadrez, colocando as pe�as no tabuleiro
	private void iniciodejogo()
	{
		tabuleiro.colocarpeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(9, 1));
	}
}
