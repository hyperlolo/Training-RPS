/*Hyperlolo
 * 11/6/17
 * Training Rock paper Scissors with others games integrated into it
 */
package trainingRPSGames;

import java.util.Scanner;

public class RPSGame {

	public static void main(String[] args) { // Main, user chooses what kind of a game mode they want to play, a random
												// mode or a straight forward mode
		Scanner reader = new Scanner(System.in);
		int gameWinner = 3;
		char userRPSChoice, retry = 0;
		System.out
				.print("Welcome to this game of rock paper scissors where you can break your ties using other games.");
		do {// Runs loop until user chooses not to play another game
			do {// Loop for picking game mode
				System.out.print("\n\nPlease pick if you would like to play the normal(N) or random(R) mode.");
				userRPSChoice = reader.next().charAt(0);
			} while (userRPSChoice != 'r' && userRPSChoice != 'R' && userRPSChoice != 'n' && userRPSChoice != 'N');
			if (userRPSChoice == 'r') {// Takes to randRps method
				gameWinner = randRps();
				if (gameWinner == 1) {// User Wins
					System.out.println("\n\nYou won this game.");
				} else if (gameWinner == 0) {// Comp wins
					System.out.println("\n\nThe computer won this game.");
				}
				do {// Asks user if they would like to play again by accepting a Y or N
					System.out.println("\nWould you like to play again? (Y/N).");
					retry = reader.next().charAt(0);
				} while (retry != 'n' && retry != 'N' && retry != 'y' && retry != 'Y');
			} else {// Normal Game start
				gameWinner = normRps();
				if (gameWinner == 1) {// User Wins
					System.out.println("\n\nYou won this game.");
				} else if (gameWinner == 0) {
					System.out.println("\n\nThe computer won this game.");
				}
				do {// Asks user if they would like to play again by accepting a Y or N
					System.out.println("\nWould you like to play again? (Y/N).");
					retry = reader.next().charAt(0);
				} while (retry != 'n' && retry != 'N' && retry != 'y' && retry != 'Y');

			}
		} while (retry != 'n' && retry != 'N');// Once user picks N after a game, the game ends.
	}// end main

	public static int normRps() {// If user chose to do a normal game then they get to pick their tie breaker
									// game rather than have it be randomly picked for them.
		Scanner reader = new Scanner(System.in);
		int userScore = 0, compScore = 0;
		int gameWinner = 3, tieScore = 3;
		int round = 1, game = 1;
		char compChoice, userChoice;
		String header1 = "Round", header2 = "Computer Chose", header3 = "User Chose";
		String header4 = "Winner", header5 = "User Score", header6 = "Computer Score";
		String winner = null, userChose = null, compChose = null;
		new Nim();
		new OddAndEven();
		System.out.println(
				"-----------------------------------------------------------------------------------------------\nYou have chosen to play Rock Paper Scissors normally");
		do {// Start of normal RPS
			String compChoices = "rps"; // The available string choices that the computer can pick from
			int compRand = (int) (Math.random() * 3); // Comp picks 1-3 numbers randomly
			compChoice = compChoices.charAt(compRand); // 1 number picked above, then assigned to the corresponding
														// string
			//System.out.println("Computer pick is " + compChoice);
			do {
				System.out.println("\nPlease pick Rock(R), Paper(P), or Scissors(S)");
				userChoice = reader.next().charAt(0);// Asks user for their choice
			} while (userChoice != 'r' && userChoice != 'R' && userChoice != 'p' && userChoice != 'P'
					&& userChoice != 's' && userChoice != 'S');// User can only exit if they pick one of these
			if (userChoice == 'r' || userChoice == 'R') {// Changes user Choice to String from char
				userChose = toString(userChoice);
			} else if (userChoice == 's' || userChoice == 'S') {
				userChose = toString(userChoice);
			} else {
				userChose = toString(userChoice);
			}
			if (compChoice == 'r' || compChoice == 'R') {// Changes Comp Choice to String from char
				compChose = toString(compChoice);
			} else if (compChoice == 's' || compChoice == 'S') {
				compChose = toString(compChoice);
			} else {
				compChose = toString(compChoice);
			}
			if (userChoice == 'r' && compChoice == 's' || userChoice == 's' && compChoice == 'p'
					|| userChoice == 'p' && compChoice == 'r' && userChoice == 's' && compChoice == 'r'
					|| userChoice == 'p' && compChoice == 's' || userChoice == 'r' && compChoice == 'p') {
				System.out.printf("%1s %15s %15s  %15s   %15s    %15s", header1, header2, header3, header4, header5,
						header6);
			} // Only runs this if the round is not a tie
			for (game = 1; game <= 1; game++) { // Runs it once and then reset for next round
				if (userChoice == compChoice) { // Tie, user can choose to break the tie with a specific game or
												// continue without choosing
					System.out.print("\nTie. Please Choose what game you would like to play.\n"
							+ "A game of Odd and Even(1) or the game of Nim(2)");
					int userGamePick = reader.nextInt();
					if (userGamePick == 1) {
						System.out.println(
								"\n-----------------------------------------------------------------------------------------------\nYou have chosen to the game of Odd and Even to break the tie");

						tieScore = OddAndEven.oddAndEven();
					} else if (userGamePick == 2) {
						System.out.println(
								"\n-----------------------------------------------------------------------------------------------\nYou have chosen to the game of Nim to break the tie");

						tieScore = Nim.nim();
					}
					if (tieScore == 1) {// User wins if return value is 1 from the game
						userScore++;
						winner = "User";
						System.out.printf("%1s %15s %15s  %15s   %15s    %15s", header1, header2, header3, header4,
								header5, header6);
						System.out.printf("%n %1s %15s   %15s %15s %15s %15s", round, compChose, userChose, winner,
								userScore, compScore);

					} else {// User loses if the return value is 0
						compScore++;
						winner = "Computer";
						System.out.printf("%1s %15s %15s  %15s   %15s    %15s", header1, header2, header3, header4,
								header5, header6);
						System.out.printf("%n %1s %15s   %15s %15s %15s %15s", round, compChose, userChose, winner,
								userScore, compScore);

					}
					round++;

				} else if (userChoice == 'r' && compChoice == 's' || userChoice == 's' && compChoice == 'p'
						|| userChoice == 'p' && compChoice == 'r') {// User wins
					userScore++;
					winner = "User";
					System.out.printf("%n %1s %15s   %15s %15s %15s %15s", round, compChose, userChose, winner,
							userScore, compScore);

					round++;
				} else {// Comp wins
					compScore++;
					winner = "Computer";
					System.out.printf("%n %1s %15s   %15s %15s %15s %15s", round, compChose, userChose, winner,
							userScore, compScore);

					round++;
				}
			}
			if (userScore >= 2) {// If user scores 2 before the computer, they win.
				return gameWinner = 1;
			}
			if (compScore >= 2) {// Computer wins if it scores 2 before the user.
				return gameWinner = 0;
			}
			game = 1;
		} while (gameWinner <= 0 || gameWinner >= 1);
		return gameWinner;
	}//End normal RPS

	public static int randRps() { // Random rock paper Scissors Game
		Scanner reader = new Scanner(System.in);
		int userScore = 0, compScore = 0;
		int gameWinner = 3, tieScore = 3;
		int round = 1, game = 1;
		char compChoice, userChoice;
		String header1 = "Round", header2 = "Computer Chose", header3 = "User Chose";
		String header4 = "Winner", header5 = "User Score", header6 = "Computer Score";
		String winner = null, userChose = null, compChose = null;
		new Nim();
		new OddAndEven();
		
		System.out.println(
				"-----------------------------------------------------------------------------------------------\nYou have chosen to play Rock Paper Scissors randomly");
		do {// Start of normal RPS
			String compChoices = "rps"; // The avaliable string choices that the computer can pick from
			int compRand = (int) (Math.random() * 3); // Comp picks 1-3 numbers randomly
			compChoice = compChoices.charAt(compRand); // 1 number picked above, then assigned to the corresponding
														// string
			//System.out.println("Computer choice is " + compChoice);
			do {
				System.out.println("\nPlease pick Rock(R), Paper(P), or Scissors(S)");
				userChoice = reader.next().charAt(0);// Asks user for their choice
			} while (userChoice != 'r' && userChoice != 'R' && userChoice != 'p' && userChoice != 'P'
					&& userChoice != 's' && userChoice != 'S');// User can only exit if they pick one of these
			if (userChoice == 'r' || userChoice == 'R') {// Changes user Choice to String from char
				userChose = toString(userChoice);
			} else if (userChoice == 's' || userChoice == 'S') {
				userChose = toString(userChoice);
			} else {
				userChose = toString(userChoice);
			}
			if (compChoice == 'r' || compChoice == 'R') {// Changes Comp Choice to String from char
				compChose = toString(compChoice);
			} else if (compChoice == 's' || compChoice == 'S') {
				compChose = toString(compChoice);
			} else {
				compChose = toString(compChoice);
			}
			if (userChoice == 'r' && compChoice == 's' || userChoice == 's' && compChoice == 'p'
					|| userChoice == 'p' && compChoice == 'r' && userChoice == 's' && compChoice == 'r'
					|| userChoice == 'p' && compChoice == 's' || userChoice == 'r' && compChoice == 'p') {
				System.out.printf("%1s %15s %15s  %15s   %15s    %15s", header1, header2, header3, header4, header5,
						header6);
			}
			for (game = 1; game <= 1; game++) { // Runs it once and then reset for next round
				if (userChoice == compChoice) { // Tie, user can choose to break the tie with a specific game or
												// continue without choosing
					System.out.print("\nTie. A game will be randomly chosen for you to play!");
					int compGamePick = (int) ((Math.random() * 2) + 1);
					if (compGamePick == 1) {
						System.out.println(
								"\n-----------------------------------------------------------------------------------------------\nThe game of Odd and Even was chosen randomly for you to break the tie");

						tieScore = OddAndEven.oddAndEven();
					} else if (compGamePick == 2) {
						System.out.println(
								"\n-----------------------------------------------------------------------------------------------\nThe game of Nim was chosen randomly for you to break the tie");

						tieScore = Nim.nim();
					}
					if (tieScore == 1) {// User wins if return value is 1 from the game
						userScore++;
						winner = "User";
						System.out.printf("%1s %15s %15s  %15s   %15s    %15s", header1, header2, header3, header4,
								header5, header6);
						System.out.printf("%n %1s %15s   %15s %15s %15s %15s", round, compChose, userChose, winner,
								userScore, compScore);
					} else {// User loses if the return value is 0
						compScore++;
						winner = "Computer";
						System.out.printf("%1s %15s %15s  %15s   %15s    %15s", header1, header2, header3, header4,
								header5, header6);
						System.out.printf("%n %1s %15s   %15s %15s %15s %15s", round, compChose, userChose, winner,
								userScore, compScore);

					}
					round++;

				} else if (userChoice == 'r' && compChoice == 's' || userChoice == 's' && compChoice == 'p'
						|| userChoice == 'p' && compChoice == 'r') {// User wins
					userScore++;
					winner = "User";
					System.out.printf("%n %1s %15s   %15s %15s %15s %15s", round, compChose, userChose, winner,
							userScore, compScore);

					round++;
				} else {// Comp wins
					compScore++;
					winner = "Computer";
					System.out.printf("%n %1s %15s   %15s %15s %15s %15s", round, compChose, userChose, winner,
							userScore, compScore);

					round++;
				}
			}
			if (userScore >= 2) {// If user scores 2 before the computer, they win.
				return gameWinner = 1;
			}
			if (compScore >= 2) {// Computer wins if it scores 2 before the user.
				return gameWinner = 0;
			}
			game = 1;
		} while (gameWinner <= 0 || gameWinner >= 1);
		return gameWinner;
	}//End random RPS

	public static String toString(char c) {//Converts char to string for header
		if (c == 'r') {
			return "Rock";
		} else if (c == 's') {
			return "Scissors";
		} else {
			return "Paper";
		}
	}
}// end class
