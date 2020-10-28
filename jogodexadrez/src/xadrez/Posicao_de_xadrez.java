/* Na classe tabuleiro, temos m�todos para colocar a pe�a dentro de um tabuleiro comum,que n�o � um tabuleiro de xadrez.
No tabuleiro de xadrez, a coluna � representada pelas letras a, b, c, d, e, f, g, h e a linha pelos n�meros 1,2,3,4,5,6,7,8.
Vamos ver nessa classe como posicionar a pe�a de acordo com essa representa��o, que s�o os dados que o usu�rio vai informar.*/

package xadrez;

import excessoes.Chessexception;
import tabuleiro.Posicao;

public class Posicao_de_xadrez {
	
	private int linha;
	private char coluna;
	
	//No xadrez, primeiro falamos a coluna, seguida da linha.
	public Posicao_de_xadrez(char coluna, int linha) {

		if(linha < 1 || linha > 8 || coluna < 'a' || coluna > 'h')
		{
			throw new Chessexception("Essa posi��o n�o existe! Os valore v�lidos s�o de a1 at� h8");
		}
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public char getColuna() {
		return coluna;
	}
	
	//M�todo que transforma essa linha e coluna em linha e coluna de um tabuleiro comum.
	/* A linha 8 do tabuleiro de xadrez equivale � linha 0 do tabuleiro comum; a linha 7 equivale � linha 1; e assim por diante...
	 Ent�o: "Linha do tabuleiro comum" = 8 - "Linha do tabuleiro de xadrez".
	 A coluna 'a' do tabuleiro de xadrez equivale � coluna 0 do tabuleiro original; a coluna 'b' equivale � 1...
	 Como cada caracterre possui um c�digo (Unicode), se fizermos: 'a' - 'a' = 0;   'b' - 'a' = 1;   'c' - 'a' = 2 ...
	 Ent�o a f�rmula geral fica: "coluna do tabuleiro comum" = "coluna do tabuleiro de xadrez" - 'a' 
	 */
	
	protected Posicao conversaodepecas()
	{
		// A linha e coluna de xadrez ser�o transformadas em linha e coluna do tabuleiro, assim, podemos instanciar um objeto do tipo Posicao.
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	// Agora vamos fazer o inverso do m�todo anterior, pegar a linha e coluna normal e converter para linha e coluna de xadrez
	
	protected static Posicao_de_xadrez conversaoinversa(Posicao posicao)
	{
		return new Posicao_de_xadrez((char)('a' - posicao.getColuna()), (8 - posicao.getLinha()));
	}

	// toString() para mostrar a posi��o de xadrez da pe�a
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
	
	
	
	

}
