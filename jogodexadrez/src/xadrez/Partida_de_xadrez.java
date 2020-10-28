// Classe fundamental, pois cont�m todas as regras do jogo de xadrez.
package xadrez;

import pecas_oficiais.Rei;
import pecas_oficiais.Torre;
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
		//chamando m�todo iniciar_com_posicao_de_xadrez 
		iniciar_com_posicao_de_xadrez('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('e', 8, new Rei(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('e', 1, new Rei(tabuleiro, Cor.BRANCO));

	}
	
	// M�todo tamb�m respons�vel por iniciar a partida de xadrez mas informando a posi��o de xadrez e n�o a posi��o da matriz como o m�todo anterior
	private void iniciar_com_posicao_de_xadrez(char coluna, int linha, Peca_de_xadrez pecadexadrez)
	{
		
		Posicao_de_xadrez x = new Posicao_de_xadrez(coluna, linha);
		tabuleiro.colocarpeca(pecadexadrez, x.conversaodepecas());
	}
	
}
