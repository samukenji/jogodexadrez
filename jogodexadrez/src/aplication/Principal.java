package aplication;

import xadrez.Partida_de_xadrez;

public class Principal {

	public static void main(String[] args) {

		Partida_de_xadrez partida= new Partida_de_xadrez();
		UI.printTabuleiro(partida.getPieces());
	}

}
