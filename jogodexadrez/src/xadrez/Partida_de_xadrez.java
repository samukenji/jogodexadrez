// Classe fundamental, pois cont�m todas as regras do jogo de xadrez.
package xadrez;

import java.util.ArrayList;
import java.util.List;

import excessoes.Chessexception;
import pecas_oficiais.Rei;
import pecas_oficiais.Torre;
import tabuleiro.Pecas;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Partida_de_xadrez {

	// Uma partida de xadrez cont�m um tabuleiro, um turno (jogada), e a vez de uma cor:
	private static Tabuleiro tabuleiro;
	private static int turno;
	private static Cor cor_da_vez;
	
	// Para ajudar no controle do jogo, vamos criar tamb�m uma lista de pe�as que est�o no tabuleiro e outra de pe�as que est�o fora do tabuleiro.
	private static List<Pecas> pecas_no_tabuleiro= new ArrayList<>();
	private static List<Pecas> pecascapturadas = new ArrayList<>();
	
	
	// O tabuleiro de xadrez cont�m sempre 8 linhas e 8 colunas
	public Partida_de_xadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		//O jogo sempre come�a com o primeiro turno e na vez das pe�as brancas, ent�o definimos inicialmente:
		turno = 1;
		cor_da_vez = Cor.BRANCO;
		iniciodejogo();
	}
	
	public int getTurno()
	{
		return turno;
	}
	
	
	public Cor getCor_da_vez()
	{
		return cor_da_vez;
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

	/* M�todo tamb�m respons�vel por iniciar a partida de xadrez mas informando a
	 posi��o de xadrez e n�o a posi��o da matriz como o m�todo anterior*/
	private void iniciar_com_posicao_de_xadrez(char coluna, int linha, Peca_de_xadrez pecadexadrez) {

		Posicao_de_xadrez x = new Posicao_de_xadrez(coluna, linha);
		tabuleiro.colocarpeca(pecadexadrez, x.conversaodepecas());
		
		// S� que, sempre que uma pe�a for colocada no tabuleiro, precisamos adicion�-la � lista de pe�as no tabuleiro (Atributo dessa classe)
		pecas_no_tabuleiro.add(pecadexadrez);
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
		proximoTurno();
		return (Peca_de_xadrez) capturedPiece;
	}
	
	//M�todo que verifica se existe pe�a em uma posi��o, para que ela seja movida
	private static void validarposicaodeorigem(Posicao posicao)
	{
		if(!tabuleiro.jatempeca(posicao))
		{
			throw new Chessexception("N�o existe pe�a nessa posi��o");
		}
		
		if(cor_da_vez != ((Peca_de_xadrez) tabuleiro.peca(posicao)).getCor())
		{
			throw new Chessexception("Voce nao pode mover esta pe�a !");
		}
		
		if(!tabuleiro.peca(posicao).pelomenosuma())
		{
			throw new Chessexception("N�o existe movimentos poss�veis para a pe�a escolhida!");
		}
	}
	

	//M�todo que verifica se tem como mover uma peca para uma determinada posi��o de destino
	private static void validarposicaodedestino(Posicao posicaodapeca, Posicao posicao_da_peca_que_ocupa_o_destino)
	{
		if(!tabuleiro.peca(posicaodapeca).movimentopossivel(posicao_da_peca_que_ocupa_o_destino))
		{
			throw new Chessexception("A pe�a n�o pode se mover para a posi��o de destino!");
		}
	}
	
	//M�todo que faz o deslocamento da pe�a
	private static Pecas makeMove(Posicao posicaodapeca, Posicao posicao_da_peca_que_ocupa_o_destino)
	{
		Pecas peca_a_ser_movida= tabuleiro.removepeca(posicaodapeca);
		Pecas peca_a_ser_retirada= tabuleiro.removepeca(posicao_da_peca_que_ocupa_o_destino);
		tabuleiro.colocarpeca(peca_a_ser_movida, posicao_da_peca_que_ocupa_o_destino);
		
		//Caso haja pe�a advers�ria, ela deve ser retirada da lista pecas_no_tabuleiro e colocada na lista pecascapturadas
		if(peca_a_ser_retirada != null)
		{
			pecas_no_tabuleiro.remove(peca_a_ser_retirada);
			pecascapturadas.add(peca_a_ser_retirada);
		}
		
		return peca_a_ser_retirada;
	}
	
	//M�todo que mostra ao usu�rio o tabuleiro de xadrez contendo as posi��es em que ele pode mover as pe�as
		public boolean[][]opcoesdedestino(Posicao_de_xadrez posicaodapeca)
		{
			//Convertendo a posi��o de xadrez para uma posi��o comum...
			Posicao posicao= posicaodapeca.conversaodepecas();
			//Validando a posi��o de origem...
			validarposicaodeorigem(posicao);
			
			return tabuleiro.peca(posicao).matrizboolean();
		}

		// M�todo respons�vel por alterar o turno, isto �, passar a jogada ao advers�rio.
		private static void proximoTurno()
		{
			turno++;
			if(cor_da_vez == Cor.BRANCO)
			{
			cor_da_vez = Cor.PRETO;
			}
			else {
				cor_da_vez = Cor.BRANCO;
			}
		}
}
