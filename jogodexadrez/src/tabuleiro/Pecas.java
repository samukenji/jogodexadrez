package tabuleiro;

public class Pecas {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	//Criando um construtor somente com tabuleiro, pois estamos considerando que a posicao da peca inicialmente seja nula, ou seja, não esteja posicionada nesse tabuleiro.
	public Pecas(Tabuleiro tabuleiro)
	{
		this.tabuleiro=tabuleiro;
	}
	
	protected Tabuleiro getTabuleiro()
	{
		return tabuleiro;
	}
	

	
}
