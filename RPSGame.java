/*Hyperlolo
 * 11/6/17
 * Training Rock paper Scissors with others games intergrated into it
 */
package trainingRPSGames;

import java.util.Scanner;

public class RPSGame {

	public static void main(String[] args) { // Main, user chooses what kind of a game mode they want to play, a random
												// mode or a straight forward mode
		Scanner reader = new Scanner(System.in);
		int userScore = 0;
		int CompScore = 0;
		char userChoice;
		System.out
				.print("Welcome to this game of rock paper scissors where you can break your ties using other games.");
		do {
			System.out.print("\nPlease pick if you would like to play the normal(N) or random(R) mode.");
			userChoice = reader.next().charAt(0);
		} while (userChoice != 'r' && userChoice != 'R' && userChoice != 'n' && userChoice != 'N');
		if (userChoice == 'r') {// Takes to randRps method
			randRps();
		}
		// If user chose to do a normal game then they get to pick their tie breaker
		// game rather than have it be randomly picked for them.

	}// end main

	public static int randRps() { // Random rock paper Scissors Game

		return 1;
	}// end rPS
}// end class
