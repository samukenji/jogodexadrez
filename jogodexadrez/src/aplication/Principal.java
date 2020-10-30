package aplication;

import java.util.Scanner;

import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_de_xadrez;

public class Principal {

	public static void main(String[] args) {

		Scanner entrar = new Scanner(System.in);
		Partida_de_xadrez partida= new Partida_de_xadrez();
		
		while (true)
		{
		UI.printTabuleiro(partida.getPieces());
		System.out.println();
		System.out.println("Posição inicial: ");
		Posicao_de_xadrez posicaoinicial= UI.entradadeposicao(entrar);
		
		System.out.println();
		System.out.print("Posição final: ");
		Posicao_de_xadrez posicaofinal= UI.entradadeposicao(entrar);
		
		Peca_de_xadrez pecacapt=Partida_de_xadrez.moverpeca(posicaoinicial, posicaofinal);
		}
		
	}

}
