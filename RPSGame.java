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
		int userScore = 0, compScore = 0, counter = 0;
		int round = 1, game = 1;
		char userRPSChoice, compChoice, tieBreaker, userChoice;
		String winner = null;
		System.out
				.print("Welcome to this game of rock paper scissors where you can break your ties using other games.");
		do {
			System.out.print("\n\nPlease pick if you would like to play the normal(N) or random(R) mode.");
			userRPSChoice = reader.next().charAt(0);
		} while (userRPSChoice != 'r' && userRPSChoice != 'R' && userRPSChoice != 'n' && userRPSChoice != 'N');
		if (userRPSChoice == 'r') {// Takes to randRps method
			System.out.println("-----------------------------------------------------------------------------------------------\nYou have chosen to play Rock Paper Scissors randomly");
			randRps();
		}
		// If user chose to do a normal game then they get to pick their tie breaker
		// game rather than have it be randomly picked for them.
		System.out.println("-----------------------------------------------------------------------------------------------\nYou have chosen to play Rock Paper Scissors normally");
		do {// Start of normal RPS
			String compChoices = "rps"; // The avaliable string choices that the computer can pick from
			int compRand = (int) (Math.random() * 3); // Comp picks 1-3 numbers randomly
			compChoice = compChoices.charAt(compRand); // 1 number picked above, then assigned to the corresponding
														// string
			do {
				System.out.println("\nPlease pick Rock(R), Paper(P), or Scissors(S)");
				userChoice = reader.next().charAt(0);// Asks user for their choice
			} while (userChoice != 'r' && userChoice != 'R' && userChoice != 'p' && userChoice != 'P'
					&& userChoice != 's' && userChoice != 'S');// User can only exit if they pick one of these
			System.out.print("Round\t\tComputer Choice\t\t  User Choice\t\t  Winner\t\tUser Score\t\tComp Score");
			for (game = 1; game <= 1; game++) { // Runs it once and then reset for next round
				if (userChoice == compChoice) { // Tie, user can choose to break the tie with a specific game or
												// continue without choosing
					winner = "Tie";
					System.out.print("\n" + round + "\t\t\t" + compChoice + "  \t\t\t" + userChoice + "\t\t   " + winner
							+ "                     " + userScore + "                       " + compScore);
					round++;
				} else if (userChoice == 'r' && compChoice == 's' || userChoice == 's' && compChoice == 'p'
						|| userChoice == 'p' && compChoice == 'r') {// User wins
					userScore++;
					winner = "User";
					System.out.print("\n" + round + "\t\t\t" + compChoice + "  \t\t\t" + userChoice + "\t\t   " + winner
							+ "                     " + userScore + "                       " + compScore);

					round++;
				} else {// Comp wins
					compScore++;
					winner = "Computer";
					System.out.print("\n" + round + "\t\t\t" + compChoice + "  \t\t\t" + userChoice + "\t\t " + winner
							+ "                   " + userScore + "                       " + compScore);
					round++;
				}
			}
			if (userScore >= 2) {
				System.out.println("\n\nYou won this game, please restart to play another game.");
				break;
			}
			if (compScore >= 2) {
				System.out.println("\n\nThe computer won this game, please restart to try and beat it.");
			}
			counter++;
			game = 1;
		} while (counter <= 10);

	}// end main

	public static int randRps() { // Random rock paper Scissors Game

		return 1;
	}// end rPS
}// end class
