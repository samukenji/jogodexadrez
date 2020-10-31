package xadrez;

import tabuleiro.Pecas;
import tabuleiro.Tabuleiro;

public abstract class Peca_de_xadrez extends Pecas{
	
	// A pe�a de xadrez tem que ter uma cor
	private Cor cor;

	// Como essa � subclasse de Pecas, precisamos chamar o super construtor para passar valores aos atributos ocultos.
	public Peca_de_xadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}
	
	
	// Criando somente o getCor(), para utilizar o valor. A cor n�o pode ser alterada em nenhuma ocasi�o...
	
	public Cor getCor()
	{
		return cor;
	}
	
	

}
