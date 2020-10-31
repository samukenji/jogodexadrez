package pecas_oficiais;

import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Peca_de_xadrez;

public class Rei extends Peca_de_xadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	
	@Override
	public String toString()
	{
		return "R";
	}
	
	@Override
	public boolean[][] matrizboolean()
	{
		boolean[][] mat= new boolean[getTabuleiro().getQddlinhas()][getTabuleiro().getQddcolunas()];
		
		return mat;
	}

}
