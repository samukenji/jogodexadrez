// Classe fundamental, pois contém todas as regras do jogo de xadrez.
package xadrez;

import pecas_oficiais.Rei;
import pecas_oficiais.Torre;
import tabuleiro.Tabuleiro;

public class Partida_de_xadrez {

	// Uma partida de xadrez contém um tabuleiro:
	private Tabuleiro tabuleiro;
	
	// O tabuleiro de xadrez contém sempre 8 linhas e 8 colunas
	public Partida_de_xadrez()
	{
		tabuleiro= new Tabuleiro(8, 8);
		iniciodejogo();
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
	
	//Método responsável por iniciar a partida de xadrez, colocando as peças no tabuleiro
	private void iniciodejogo()
	{
		//chamando método iniciar_com_posicao_de_xadrez 
		iniciar_com_posicao_de_xadrez('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('e', 8, new Rei(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('e', 1, new Rei(tabuleiro, Cor.BRANCO));

	}
	
	// Método também responsável por iniciar a partida de xadrez mas informando a posição de xadrez e não a posição da matriz como o método anterior
	private void iniciar_com_posicao_de_xadrez(char coluna, int linha, Peca_de_xadrez pecadexadrez)
	{
		
		Posicao_de_xadrez x = new Posicao_de_xadrez(coluna, linha);
		tabuleiro.colocarpeca(pecadexadrez, x.conversaodepecas());
	}
	
}
