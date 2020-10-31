// Todas as peças oficiais (Torre, cavalo, bispo...) terão uma posição, estarão em um tabuleiro e terão uma cor. Portanto, extendem a classe Peca_de_xadrez
//Resumindo, Pecas é superclasse de Peca_de_xadrez, que é superclasse de todas as pecas_oficiais.
package pecas_oficiais;

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
	
	@Override
	public boolean[][] matrizboolean()
	{
		boolean[][] mat= new boolean[getTabuleiro().getQddlinhas()][getTabuleiro().getQddcolunas()];
		
		return mat;
	}
}
