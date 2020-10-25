package tabuleiro;

public class Tabuleiro {

	private int qddlinhas;
	private int qddcolunas;
	private Pecas[][] matrizdepecas;
	
	public Tabuleiro(int qddlinhas, int qddcolunas)
	{
		this.qddlinhas=qddlinhas;
		this.qddcolunas=qddcolunas;
		//A matriz de peças depende da quantidade de linhas e colunas que o tabuleiro tiver...
		matrizdepecas= new Pecas[qddlinhas][qddcolunas];
	}
	
	// Por enquanto, não vamos criar getters e setters para a matriz de peças...
	
	public int getQddlinhas()
	{
		return qddlinhas;
	}
	
	public void setQddlinhas(int qddlinhas)
	{
		this.qddlinhas=qddlinhas;
	}
	
	public int getQddcolunas()
	{
		return qddcolunas;
	}
	public void setQddcolunas(int qddcolunas)
	{
		this.qddcolunas= qddcolunas;
	}
}
