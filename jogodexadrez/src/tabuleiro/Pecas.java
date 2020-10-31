package tabuleiro;

public abstract class Pecas {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	// Criando um construtor somente com tabuleiro, pois estamos considerando que a
	// posicao da peca inicialmente seja nula, ou seja, n�o esteja posicionada nesse
	// tabuleiro.
	public Pecas(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Pecas() {

	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	// M�todo abstrato que retorna uma matriz booleana, ou seja, uma matriz que
	// cont�m um valor verdadeiro ou um valor falso
	public abstract boolean[][] matrizboolean();

	// M�todo que verifica se uma posi��o da matriz booleana � true ou false, isto
	// �, se pode receber uma pe�a. Retorna true ou false
	public boolean movimentopossivel(Posicao posicao) {
		return matrizboolean()[posicao.getLinha()][posicao.getColuna()];
	}

	// M�todo que diz se existe pelo menos um movimento poss�vel para a pe�a
	public boolean pelomenosuma() 
	{
		// Para isso, ser� necess�rio andar na matriz e verificar quais posi��es cont�m
		// true.
		// Criando uma vari�vel para representar a matriz...
		boolean[][] mat = matrizboolean();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}

		return false;
	}

}
