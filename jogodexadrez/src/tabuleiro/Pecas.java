package tabuleiro;

public abstract class Pecas {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	// Criando um construtor somente com tabuleiro, pois estamos considerando que a
	// posicao da peca inicialmente seja nula, ou seja, não esteja posicionada nesse
	// tabuleiro.
	public Pecas(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Pecas() {

	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	// Método abstrato que retorna uma matriz booleana, ou seja, uma matriz que
	// contém um valor verdadeiro ou um valor falso
	public abstract boolean[][] matrizboolean();

	// Método que verifica se uma posição da matriz booleana é true ou false, isto
	// é, se pode receber uma peça. Retorna true ou false
	public boolean movimentopossivel(Posicao posicao) {
		return matrizboolean()[posicao.getLinha()][posicao.getColuna()];
	}

	// Método que diz se existe pelo menos um movimento possível para a peça
	public boolean pelomenosuma() 
	{
		// Para isso, será necessário andar na matriz e verificar quais posições contém
		// true.
		// Criando uma variável para representar a matriz...
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
