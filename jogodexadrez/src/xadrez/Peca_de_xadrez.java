package xadrez;

import tabuleiro.Pecas;
import tabuleiro.Posicao;
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
	
	//M�todo importante para realizar um movimento. Verifica se existe pe�a advers�ria em uma posi��o.
	protected boolean existepecaadversaria(Posicao posicao)
	{
		Peca_de_xadrez x = (Peca_de_xadrez) getTabuleiro().peca(posicao);
		return x != null && x.getCor() != cor;
	}
	
	

}
