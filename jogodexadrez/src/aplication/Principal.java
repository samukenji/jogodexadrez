package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import excessoes.Chessexception;
import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_de_xadrez;

public class Principal {

	public static void main(String[] args) {

		Scanner entrar = new Scanner(System.in);
		Partida_de_xadrez partida = new Partida_de_xadrez();

		while (true) {


			try {
				UI.clearScreen();
				UI.printTabuleiro(partida.getPieces());
				System.out.println();
				System.out.print("Posição inicial: ");
				Posicao_de_xadrez posicaoinicial = UI.entradadeposicao(entrar);

				System.out.println();
				System.out.print("Posição final: ");
				Posicao_de_xadrez posicaofinal = UI.entradadeposicao(entrar);

				Peca_de_xadrez pecacapturada = Partida_de_xadrez.moverpeca(posicaoinicial, posicaofinal);
			} 
			catch (Chessexception excessao) {
				System.out.println(excessao.getMessage());
				entrar.nextLine();
			} 
			catch (InputMismatchException excessao) {
				System.out.println(excessao.getMessage());
				entrar.nextLine();
			
			}

		}

	}

}
