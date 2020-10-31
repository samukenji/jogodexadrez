// Todas as pe�as oficiais (Torre, cavalo, bispo...) ter�o uma posi��o, estar�o em um tabuleiro e ter�o uma cor. Portanto, extendem a classe Peca_de_xadrez
//Resumindo, Pecas � superclasse de Peca_de_xadrez, que � superclasse de todas as pecas_oficiais.
package pecas_oficiais;

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
	
	@Override
	public boolean[][] matrizboolean()
	{
		boolean[][] mat= new boolean[getTabuleiro().getQddlinhas()][getTabuleiro().getQddcolunas()];
		
		return mat;
	}
}
