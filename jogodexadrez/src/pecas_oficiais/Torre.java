// Todas as pe�as oficiais (Torre, cavalo, bispo...) ter�o uma posi��o, estar�o em um tabuleiro e ter�o uma cor. Portanto, extendem a classe Peca_de_xadrez
//Resumindo, Pecas � superclasse de Peca_de_xadrez, que � superclasse de todas as pecas_oficiais.
package pecas_oficiais;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Peca_de_xadrez;

public class Torre extends Peca_de_xadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	//Precisamos tamb�m imprimir essa pe�a no tabuleiro (Ela ser� representada pela letra T)
	
	@Override
	public String toString()
	{
		return "T";
	}
	
	//M�todo que define os movimentos poss�veis para a torre em qualquer posi��o em que ela esteja
	@Override
	public boolean[][] matrizboolean()
	{
		boolean[][] mat= new boolean[getTabuleiro().getQddlinhas()][getTabuleiro().getQddcolunas()];
		
		Posicao p= new Posicao(0, 0);
		
		// MOVIMENTO PARA CIMA
		p.setValues(posicao.getLinha()-1, posicao.getColuna());
		//A pe�a poder� se mover enquanto...
		while(getTabuleiro().existeposicao(p) && !getTabuleiro().jatempeca(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha()-1);
		}
		// Considerando tamb�m a pe�a advers�ria...
		if(getTabuleiro().existeposicao(p) && existepecaadversaria(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;

		}
		
		// MOVIMENTO PARA BAIXO
		p.setValues(posicao.getLinha()+1, posicao.getColuna());
		//A pe�a poder� se mover enquanto...
		while(getTabuleiro().existeposicao(p) && !getTabuleiro().jatempeca(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha()+1);
		}
		// Considerando tamb�m a pe�a advers�ria...
		if(getTabuleiro().existeposicao(p) && existepecaadversaria(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;

		}
		
		//MOVIMENTO PARA A ESQUERDA
		p.setValues(posicao.getLinha(), posicao.getColuna()-1);
		//A pe�a poder� se mover enquanto...
		while(getTabuleiro().existeposicao(p) && !getTabuleiro().jatempeca(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna()-1);
		}
		// Considerando tamb�m a pe�a advers�ria...
		if(getTabuleiro().existeposicao(p) && existepecaadversaria(p))
		{
			mat[p.getLinha()][p.getColuna()] = true;

		}
		
		
		//MOVIMENTO PARA A DIREITA
				p.setValues(posicao.getLinha(), posicao.getColuna()+1);
				//A pe�a poder� se mover enquanto...
				while(getTabuleiro().existeposicao(p) && !getTabuleiro().jatempeca(p))
				{
					mat[p.getLinha()][p.getColuna()] = true;
					p.setColuna(p.getColuna()+1);
				}
				// Considerando tamb�m a pe�a advers�ria...
				if(getTabuleiro().existeposicao(p) && existepecaadversaria(p))
				{
					mat[p.getLinha()][p.getColuna()] = true;

				}
				
				
		return mat;
	}
}
