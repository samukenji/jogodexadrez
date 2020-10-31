// Todas as peças oficiais (Torre, cavalo, bispo...) terão uma posição, estarão em um tabuleiro e terão uma cor. Portanto, extendem a classe Peca_de_xadrez
//Resumindo, Pecas é superclasse de Peca_de_xadrez, que é superclasse de todas as pecas_oficiais.
package pecas_oficiais;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Peca_de_xadrez;

public class Torre extends Peca_de_xadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	//Precisamos também imprimir essa peça no tabuleiro (Ela será representada pela letra T)
	
	@Override
	public String toString()
	{
		return "T";
	}
	
	//Método que define os movimentos possíveis para a torre em qualquer posição em que ela esteja
	@Override
	public boolean[][] matrizboolean()
	{
		boolean[][] mat= new boolean[getTabuleiro().getQddlinhas()][getTabuleiro().getQddcolunas()];
		
		Posicao p= new Posicao(0, 0);
		
		// MOVIMENTO PARA CIMA
		p.setValues(posicao.getLinha()-1, posicao.getColuna());
		//A peça poderá se mover enquanto...
		while(getTabuleiro().existeposicao(p) && !getTabuleiro().jatempeca(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha()-1);
		}
		// Considerando também a peça adversária...
		if(getTabuleiro().existeposicao(p) && existepecaadversaria(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;

		}
		
		// MOVIMENTO PARA BAIXO
		p.setValues(posicao.getLinha()+1, posicao.getColuna());
		//A peça poderá se mover enquanto...
		while(getTabuleiro().existeposicao(p) && !getTabuleiro().jatempeca(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha()+1);
		}
		// Considerando também a peça adversária...
		if(getTabuleiro().existeposicao(p) && existepecaadversaria(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;

		}
		
		//MOVIMENTO PARA A ESQUERDA
		p.setValues(posicao.getLinha(), posicao.getColuna()-1);
		//A peça poderá se mover enquanto...
		while(getTabuleiro().existeposicao(p) && !getTabuleiro().jatempeca(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna()-1);
		}
		// Considerando também a peça adversária...
		if(getTabuleiro().existeposicao(p) && existepecaadversaria(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;

		}
		
		
		//MOVIMENTO PARA A DIREITA
				p.setValues(posicao.getLinha(), posicao.getColuna()+1);
				//A peça poderá se mover enquanto...
				while(getTabuleiro().existeposicao(p) && !getTabuleiro().jatempeca(p))
				{
					mat[p.getLinha()][p.getColuna()] = true;
					p.setColuna(p.getColuna()+1);
				}
				// Considerando também a peça adversária...
				if(getTabuleiro().existeposicao(p) && existepecaadversaria(p))
				{
					mat[p.getLinha()][p.getColuna()] = true;

				}
				
				
		return mat;
	}
}
