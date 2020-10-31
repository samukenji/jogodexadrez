package xadrez;

import tabuleiro.Pecas;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class Peca_de_xadrez extends Pecas{
	
	// A peça de xadrez tem que ter uma cor
	private Cor cor;

	// Como essa é subclasse de Pecas, precisamos chamar o super construtor para passar valores aos atributos ocultos.
	public Peca_de_xadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}
	
	
	// Criando somente o getCor(), para utilizar o valor. A cor não pode ser alterada em nenhuma ocasião...
	
	public Cor getCor()
	{
		return cor;
	}
	
	//Método importante para realizar um movimento. Verifica se existe peça adversária em uma posição.
	protected boolean existepecaadversaria(Posicao posicao)
	{
		Peca_de_xadrez x = (Peca_de_xadrez) getTabuleiro().peca(posicao);
		return x != null && x.getCor() != cor;
	}
	
	

}
