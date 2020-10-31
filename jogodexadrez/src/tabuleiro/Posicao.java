// A posição de uma peça será usada na classe Pecas e extende a classe Peca_de_xadrez
package tabuleiro;

public class Posicao {

	private int linha;
	private int coluna;
	
	public Posicao(int linha, int coluna)
	{
		this.linha= linha;
		this.coluna= coluna;
	}
	
	public int getLinha()
	{
		return linha;
	}
	
	public void setLinha(int linha)
	{
		this.linha= linha;
	}
	
	public int getColuna()
	{
		return coluna;
	}
	
	public void setColuna(int coluna)
	{
		this.coluna=coluna;
	}

	//Método usado para mudar a linha e a coluna de uma posição
	public void setValues(int linha, int coluna)
	{
		this.linha=linha;
		this.coluna=coluna;
	}
	
	@Override
	public String toString() {
		return linha +", " +coluna;
	}
	
	
}
