// Classe fundamental, pois contém todas as regras do jogo de xadrez.
package xadrez;

import excessoes.Chessexception;
import pecas_oficiais.Rei;
import pecas_oficiais.Torre;
import tabuleiro.Pecas;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Partida_de_xadrez {

	// Uma partida de xadrez contém um tabuleiro:
	private static Tabuleiro tabuleiro;

	// O tabuleiro de xadrez contém sempre 8 linhas e 8 colunas
	public Partida_de_xadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciodejogo();
	}

	// Método que retorna uma matriz de peças de xadrez para essa essa partida

	public Peca_de_xadrez[][] getPieces() {
		// Criando uma matriz com quantidade de linhas e colunas do tabuleiro.
		Peca_de_xadrez[][] matriz = new Peca_de_xadrez[tabuleiro.getQddlinhas()][tabuleiro.getQddcolunas()];

		// Para cada posição dessa matriz eu vou associar uma peça de xadrez. Para isso,
		// preciso usar o downcasting (Peca_de_xadrez)

		for (int i = 0; i < tabuleiro.getQddlinhas(); i++) {
			for (int j = 0; j < tabuleiro.getQddcolunas(); j++) {
				matriz[i][j] = (Peca_de_xadrez) tabuleiro.peca(i, j);
			}
		}

		return matriz;
	}

	// Método responsável por iniciar a partida de xadrez, colocando as peças no tabuleiro
	private void iniciodejogo() {
		// chamando método iniciar_com_posicao_de_xadrez
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

	// Método também responsável por iniciar a partida de xadrez mas informando a
	// posição de xadrez e não a posição da matriz como o método anterior
	private void iniciar_com_posicao_de_xadrez(char coluna, int linha, Peca_de_xadrez pecadexadrez) {

		Posicao_de_xadrez x = new Posicao_de_xadrez(coluna, linha);
		tabuleiro.colocarpeca(pecadexadrez, x.conversaodepecas());
	}
	
	//Método que pega a peça removida pelo método removepeca() da classe Tabuleiro e coloca na posição de destino
	public static Peca_de_xadrez moverpeca(Posicao_de_xadrez posicaoinicial, Posicao_de_xadrez posicaofinal)
	{
		// Fazendo a conversão da posição de xadrez para a posição da matriz
		Posicao x= posicaoinicial.conversaodepecas();
		Posicao y= posicaofinal.conversaodepecas();
		validarposicaodeorigem(x);
		validarposicaodedestino(x,y);
		Pecas capturedPiece = makeMove(x,y);
		return (Peca_de_xadrez) capturedPiece;
	}
	
	//Método que verifica se existe peça em uma posição, para que ela seja movida
	private static void validarposicaodeorigem(Posicao posicao)
	{
		if(!tabuleiro.jatempeca(posicao))
		{
			throw new Chessexception("Não existe peça nessa posição");
		}
		
		if(!tabuleiro.peca(posicao).pelomenosuma())
		{
			throw new Chessexception("Não existe movimentos possíveis para a peça escolhida!");
		}
	}
	
	private static void validarposicaodedestino(Posicao posicaodapeca, Posicao posicao_da_peca_que_ocupa_o_destino)
	{
		if(!tabuleiro.peca(posicaodapeca).movimentopossivel(posicao_da_peca_que_ocupa_o_destino))
		{
			throw new Chessexception("A peça não pode se mover para a posição de destino!");
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
