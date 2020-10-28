/* Na classe tabuleiro, temos métodos para colocar a peça dentro de um tabuleiro comum,que não é um tabuleiro de xadrez.
No tabuleiro de xadrez, a coluna é representada pelas letras a, b, c, d, e, f, g, h e a linha pelos números 1,2,3,4,5,6,7,8.
Vamos ver nessa classe como posicionar a peça de acordo com essa representação, que são os dados que o usuário vai informar.*/

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
			throw new Chessexception("Essa posição não existe! Os valore válidos são de a1 até h8");
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
	
	//Método que transforma essa linha e coluna em linha e coluna de um tabuleiro comum.
	/* A linha 8 do tabuleiro de xadrez equivale à linha 0 do tabuleiro comum; a linha 7 equivale à linha 1; e assim por diante...
	 Então: "Linha do tabuleiro comum" = 8 - "Linha do tabuleiro de xadrez".
	 A coluna 'a' do tabuleiro de xadrez equivale à coluna 0 do tabuleiro original; a coluna 'b' equivale à 1...
	 Como cada caracterre possui um código (Unicode), se fizermos: 'a' - 'a' = 0;   'b' - 'a' = 1;   'c' - 'a' = 2 ...
	 Então a fórmula geral fica: "coluna do tabuleiro comum" = "coluna do tabuleiro de xadrez" - 'a' 
	 */
	
	protected Posicao conversaodepecas()
	{
		// A linha e coluna de xadrez serão transformadas em linha e coluna do tabuleiro, assim, podemos instanciar um objeto do tipo Posicao.
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	// Agora vamos fazer o inverso do método anterior, pegar a linha e coluna normal e converter para linha e coluna de xadrez
	
	protected static Posicao_de_xadrez conversaoinversa(Posicao posicao)
	{
		return new Posicao_de_xadrez((char)('a' - posicao.getColuna()), (8 - posicao.getLinha()));
	}

	// toString() para mostrar a posição de xadrez da peça
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
	
	
	
	

}
