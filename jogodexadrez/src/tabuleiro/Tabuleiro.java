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
	
	//Método que retorna uma peça que está em uma determinada linha e coluna do tabuleiro (matriz de peças). 

	public Pecas peca(int qddlinhas, int qddcolunas)
	{
		return matrizdepecas[qddlinhas][qddcolunas];
	}
	
	//Método que retorna uma peça que está em uma determinada posição
	public Pecas peca(Posicao posicao)
	{
		return matrizdepecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	// Método que coloca uma peça no tabuleiro. 
	public void colocarpeca(Pecas peca, Posicao posicao)
	{
		//Uma posição da matriz de peças agora vai receber uma peça
		matrizdepecas[posicao.getLinha()][posicao.getColuna()]= peca;
		// A partir de agora, a posição da peça não será mais nula
		peca.posicao=posicao;
	}
}
