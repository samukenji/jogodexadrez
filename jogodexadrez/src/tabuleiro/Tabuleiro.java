package tabuleiro;

public class Tabuleiro {

	private int qddlinhas;
	private int qddcolunas;
	private Pecas[][] matrizdepecas;
	
	public Tabuleiro(int qddlinhas, int qddcolunas)
	{
		this.qddlinhas=qddlinhas;
		this.qddcolunas=qddcolunas;
		//A matriz de pe�as depende da quantidade de linhas e colunas que o tabuleiro tiver...
		matrizdepecas= new Pecas[qddlinhas][qddcolunas];
	}
	
	// Por enquanto, n�o vamos criar getters e setters para a matriz de pe�as...
	
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
	
	//M�todo que retorna uma pe�a que est� em uma determinada linha e coluna do tabuleiro (matriz de pe�as). 

	public Pecas peca(int qddlinhas, int qddcolunas)
	{
		return matrizdepecas[qddlinhas][qddcolunas];
	}
	
	//M�todo que retorna uma pe�a que est� em uma determinada posi��o
	public Pecas peca(Posicao posicao)
	{
		return matrizdepecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	// M�todo que coloca uma pe�a no tabuleiro. 
	public void colocarpeca(Pecas peca, Posicao posicao)
	{
		//Uma posi��o da matriz de pe�as agora vai receber uma pe�a
		matrizdepecas[posicao.getLinha()][posicao.getColuna()]= peca;
		// A partir de agora, a posi��o da pe�a n�o ser� mais nula
		peca.posicao=posicao;
	}
}
