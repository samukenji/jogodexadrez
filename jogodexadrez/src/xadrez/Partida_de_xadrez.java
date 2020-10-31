// Classe fundamental, pois cont�m todas as regras do jogo de xadrez.
package xadrez;

import excessoes.Chessexception;
import pecas_oficiais.Rei;
import pecas_oficiais.Torre;
import tabuleiro.Pecas;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Partida_de_xadrez {

	// Uma partida de xadrez cont�m um tabuleiro:
	private static Tabuleiro tabuleiro;

	// O tabuleiro de xadrez cont�m sempre 8 linhas e 8 colunas
	public Partida_de_xadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciodejogo();
	}

	// M�todo que retorna uma matriz de pe�as de xadrez para essa essa partida

	public Peca_de_xadrez[][] getPieces() {
		// Criando uma matriz com quantidade de linhas e colunas do tabuleiro.
		Peca_de_xadrez[][] matriz = new Peca_de_xadrez[tabuleiro.getQddlinhas()][tabuleiro.getQddcolunas()];

		// Para cada posi��o dessa matriz eu vou associar uma pe�a de xadrez. Para isso,
		// preciso usar o downcasting (Peca_de_xadrez)

		for (int i = 0; i < tabuleiro.getQddlinhas(); i++) {
			for (int j = 0; j < tabuleiro.getQddcolunas(); j++) {
				matriz[i][j] = (Peca_de_xadrez) tabuleiro.peca(i, j);
			}
		}

		return matriz;
	}

	// M�todo respons�vel por iniciar a partida de xadrez, colocando as pe�as no tabuleiro
	private void iniciodejogo() {
		// chamando m�todo iniciar_com_posicao_de_xadrez
		iniciar_com_posicao_de_xadrez('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		iniciar_com_posicao_de_xadrez('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		iniciar_com_posicao_de_xadrez('c', 7, new Torre(tabuleiro, Cor.PRETO));
		iniciar_com_posicao_de_xadrez('c', 8, new Torre(tabuleiro, Cor.PRETO));
		iniciar_com_posicao_de_xadrez('d', 7, new Torre(tabuleiro, Cor.PRETO));
		iniciar_com_posicao_de_xadrez('e', 7, new Torre(tabuleiro, Cor.PRETO));
		iniciar_com_posicao_de_xadrez('e', 8, new Torre(tabuleiro, Cor.PRETO));
		iniciar_com_posicao_de_xadrez('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}

	// M�todo tamb�m respons�vel por iniciar a partida de xadrez mas informando a
	// posi��o de xadrez e n�o a posi��o da matriz como o m�todo anterior
	private void iniciar_com_posicao_de_xadrez(char coluna, int linha, Peca_de_xadrez pecadexadrez) {

		Posicao_de_xadrez x = new Posicao_de_xadrez(coluna, linha);
		tabuleiro.colocarpeca(pecadexadrez, x.conversaodepecas());
	}
	
	//M�todo que pega a pe�a removida pelo m�todo removepeca() da classe Tabuleiro e coloca na posi��o de destino
	public static Peca_de_xadrez moverpeca(Posicao_de_xadrez posicaoinicial, Posicao_de_xadrez posicaofinal)
	{
		// Fazendo a convers�o da posi��o de xadrez para a posi��o da matriz
		Posicao x= posicaoinicial.conversaodepecas();
		Posicao y= posicaofinal.conversaodepecas();
		validarposicaodeorigem(x);
		validarposicaodedestino(x,y);
		Pecas capturedPiece = makeMove(x,y);
		return (Peca_de_xadrez) capturedPiece;
	}
	
	//M�todo que verifica se existe pe�a em uma posi��o, para que ela seja movida
	private static void validarposicaodeorigem(Posicao posicao)
	{
		if(!tabuleiro.jatempeca(posicao))
		{
			throw new Chessexception("N�o existe pe�a nessa posi��o");
		}
		
		if(!tabuleiro.peca(posicao).pelomenosuma())
		{
			throw new Chessexception("N�o existe movimentos poss�veis para a pe�a escolhida!");
		}
	}
	
	private static void validarposicaodedestino(Posicao posicaodapeca, Posicao posicao_da_peca_que_ocupa_o_destino)
	{
		if(!tabuleiro.peca(posicaodapeca).movimentopossivel(posicao_da_peca_que_ocupa_o_destino))
		{
			throw new Chessexception("A pe�a n�o pode se mover para a posi��o de destino!");
		}
	}
	private static Pecas makeMove(Posicao posicaodapeca, Posicao posicao_da_peca_que_ocupa_o_destino)
	{
		Pecas peca_a_ser_movida= tabuleiro.removepeca(posicaodapeca);
		Pecas peca_a_ser_retirada= tabuleiro.removepeca(posicao_da_peca_que_ocupa_o_destino);
		tabuleiro.colocarpeca(peca_a_ser_movida, posicao_da_peca_que_ocupa_o_destino);
		
		return peca_a_ser_retirada;
	}

}
