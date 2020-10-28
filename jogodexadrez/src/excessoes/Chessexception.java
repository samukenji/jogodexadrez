package excessoes;

public class Chessexception extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public Chessexception(String mensagem)
	{
		super(mensagem);
	}
}
