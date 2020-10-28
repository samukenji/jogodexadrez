package tabuleiro;

import excessoes.Boardexception;

public class Tabuleiro {

	private int qddlinhas;
	private int qddcolunas;
	private Pecas[][] matrizdepecas;
	
	public Tabuleiro(int qddlinhas, int qddcolunas)
	{
		// N�o existem tabuleiros com quantidades de linhas e colunas melhores que 1. Caso seja, vamos lan�ar uma Boardexception.
		
		if(qddlinhas<1 || qddcolunas<1)
		{
			throw new Boardexception("N�o existe tabuleiro com esses valores!");
		}
		
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
	
	public int getQddcolunas()
	{
		return qddcolunas;
	}

	//M�todo que retorna uma pe�a que est� em uma determinada linha e coluna do tabuleiro (matriz de pe�as). 

	public Pecas peca(int qddlinhas, int qddcolunas)
	{
		// Se a linha ou coluna n�o existir, tamb�m precisamos lan�ar uma excess�o do tipo Boardexception.
		if(!existeposicao(qddlinhas, qddcolunas))
		{
			throw new Boardexception("N�o existe essa posi��o!");
		}
		return matrizdepecas[qddlinhas][qddcolunas];
	}
	
	//M�todo que retorna uma pe�a que est� em uma determinada posi��o
	public Pecas peca(Posicao posicao)
	{
		if(!existeposicao(posicao))
		{
			throw new Boardexception("N�o existe essa posi��o");
		}
		return matrizdepecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	// M�todo que coloca uma pe�a no tabuleiro. 
	public void colocarpeca(Pecas peca, Posicao posicao)
	{
		// Caso ja exista uma pe�a nessa posi��o, devemos lan�ar uma excess�o
		if(jatempeca(posicao))
		{
			throw new Boardexception("J� existe uma pe�a nessa posi��o");
		}
		
		//Uma posi��o da matriz de pe�as agora vai receber uma pe�a
		matrizdepecas[posicao.getLinha()][posicao.getColuna()]= peca;
		// A partir de agora, a posi��o da pe�a n�o ser� mais nula
		peca.posicao=posicao;
	}
	
	//M�todos que verificam se a posi��o existe ou n�o
	public boolean existeposicao(int linha, int coluna)
	{
		//A linha deve ser maior ou igual a zero, lembrando que a matriz possui linha 0, e menor que a quantidade de linhas do tabuleiro. O mesmo vale para coluna
		return linha>=0 && linha< qddlinhas && coluna >=0 && coluna< qddcolunas; // Retornando true para verdadeiro ou false para falso.
	}
	
	public boolean existeposicao(Posicao posicao)
	{
		return existeposicao(posicao.getLinha(), posicao.getColuna());
	}
	
	// M�todo que verifica se em uma determinada posi��o j� existe uma pe�a
	public boolean jatempeca(Posicao posicao)
	{	//Antes de verificar se h� uma pe�a ocupando a posi��o, verificamos se essa posi��o existe
		if(!existeposicao(posicao))
		{
			throw new Boardexception("Essa posi��o n�o existe!");
		}
		//Usando o m�todo "peca" dessa mesma classe. O c�digo abaixo verifica se uma pe�a ocupa esse lugar e retorna verdadeiro ou falso 
		return peca(posicao) != null;
	}
}
