package pecas_oficiais;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Peca_de_xadrez;

public class Rei extends Peca_de_xadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	// Método auxiliar usado para verificar se o rei pode ser movido para uma
	// determinada posição requerida
	private boolean pode_mover(Posicao posicao) {
		// Primeiro vou verificar se a posição dada é nula ou se há uma peça adversária.
		// Se uma dessas condições for atendida o rei pode ser movido
		Peca_de_xadrez p = (Peca_de_xadrez) getTabuleiro().peca(posicao);

		// O retorno será true ou false de acordo com a condição booleana indicada
		return p == null || p.getCor() != getCor();
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] matrizboolean() {
		boolean[][] mat = new boolean[getTabuleiro().getQddlinhas()][getTabuleiro().getQddcolunas()];

		// Objeto auxiliar que tem seus valores mudados para realizar os testes.
		Posicao p = new Posicao(0, 0);

		// Movimentos p/ cima
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().existeposicao(p) && pode_mover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Movimentos p/ baixo
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().existeposicao(p) && pode_mover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Movimentos p/ esquerda
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().existeposicao(p) && pode_mover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Movimentos p/ direita
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().existeposicao(p) && pode_mover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Movimentos p/ cima e para a esquerda (noroeste)
				p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
				if (getTabuleiro().existeposicao(p) && pode_mover(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
				// Movimentos p/ cima e para a direita (nordeste)
				p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
				if (getTabuleiro().existeposicao(p) && pode_mover(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}

				// Movimentos p/ baixo e para a esquerda (sudoeste)
				p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
				if (getTabuleiro().existeposicao(p) && pode_mover(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
				// Movimentos p/ cima e para a direita (sudeste)
				p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
				if (getTabuleiro().existeposicao(p) && pode_mover(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
				
		return mat;
	}

}
