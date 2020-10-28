package tabuleiro;

import excessoes.Boardexception;

public class Tabuleiro {

	private int qddlinhas;
	private int qddcolunas;
	private Pecas[][] matrizdepecas;
	
	public Tabuleiro(int qddlinhas, int qddcolunas)
	{
		// Não existem tabuleiros com quantidades de linhas e colunas melhores que 1. Caso seja, vamos lançar uma Boardexception.
		
		if(qddlinhas<1 || qddcolunas<1)
		{
			throw new Boardexception("Não existe tabuleiro com esses valores!");
		}
		
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
	
	public int getQddcolunas()
	{
		return qddcolunas;
	}

	//Método que retorna uma peça que está em uma determinada linha e coluna do tabuleiro (matriz de peças). 

	public Pecas peca(int qddlinhas, int qddcolunas)
	{
		// Se a linha ou coluna não existir, também precisamos lançar uma excessão do tipo Boardexception.
		if(!existeposicao(qddlinhas, qddcolunas))
		{
			throw new Boardexception("Não existe essa posição!");
		}
		return matrizdepecas[qddlinhas][qddcolunas];
	}
	
	//Método que retorna uma peça que está em uma determinada posição
	public Pecas peca(Posicao posicao)
	{
		if(!existeposicao(posicao))
		{
			throw new Boardexception("Não existe essa posição");
		}
		return matrizdepecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	// Método que coloca uma peça no tabuleiro. 
	public void colocarpeca(Pecas peca, Posicao posicao)
	{
		// Caso ja exista uma peça nessa posição, devemos lançar uma excessão
		if(jatempeca(posicao))
		{
			throw new Boardexception("Já existe uma peça nessa posição");
		}
		
		//Uma posição da matriz de peças agora vai receber uma peça
		matrizdepecas[posicao.getLinha()][posicao.getColuna()]= peca;
		// A partir de agora, a posição da peça não será mais nula
		peca.posicao=posicao;
	}
	
	//Métodos que verificam se a posição existe ou não
	public boolean existeposicao(int linha, int coluna)
	{
		//A linha deve ser maior ou igual a zero, lembrando que a matriz possui linha 0, e menor que a quantidade de linhas do tabuleiro. O mesmo vale para coluna
		return linha>=0 && linha< qddlinhas && coluna >=0 && coluna< qddcolunas; // Retornando true para verdadeiro ou false para falso.
	}
	
	public boolean existeposicao(Posicao posicao)
	{
		return existeposicao(posicao.getLinha(), posicao.getColuna());
	}
	
	// Método que verifica se em uma determinada posição já existe uma peça
	public boolean jatempeca(Posicao posicao)
	{	//Antes de verificar se há uma peça ocupando a posição, verificamos se essa posição existe
		if(!existeposicao(posicao))
		{
			throw new Boardexception("Essa posição não existe!");
		}
		//Usando o método "peca" dessa mesma classe. O código abaixo verifica se uma peça ocupa esse lugar e retorna verdadeiro ou falso 
		return peca(posicao) != null;
	}
}
