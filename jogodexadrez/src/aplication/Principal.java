package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import excessoes.Chessexception;
import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_de_xadrez;

public class Principal {

	public static void main(String[] args) {

		Scanner entrar = new Scanner(System.in);
		Partida_de_xadrez partida = new Partida_de_xadrez();
		List<Peca_de_xadrez> pecascapturadas = new ArrayList<>();

		while (true) {


			try {
				
				//Digitar posição da peça a mover
				UI.clearScreen();
				UI.printPartida(partida, pecascapturadas);
				System.out.println();
				System.out.print("Posição inicial: ");
				Posicao_de_xadrez posicaoinicial = UI.entradadeposicao(entrar);

				//Possíveis opções de destino sendo mostradas
				boolean[][] movimentosquedaprafazer= partida.opcoesdedestino(posicaoinicial);
				UI.clearScreen();
				UI.printTabuleiro(partida.getPieces(), movimentosquedaprafazer);
				
				System.out.println();
				System.out.print("Posição final: ");
				Posicao_de_xadrez posicaofinal = UI.entradadeposicao(entrar);

				Peca_de_xadrez pecacapturada = Partida_de_xadrez.moverpeca(posicaoinicial, posicaofinal);
				
				if(pecacapturada != null)
				{
					pecascapturadas.add(pecacapturada);
				}
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

	private static boolean[][] opcoesdedestino(Posicao_de_xadrez posicaoinicial) {
		// TODO Auto-generated method stub
		return null;
	}

}
