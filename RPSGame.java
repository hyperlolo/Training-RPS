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
		int gameWinner = 3;
		char userRPSChoice, retry = 0;
		String winner = null;
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
		char compChoice, tieBreaker, userChoice;
		String heading1 = "Round", heading2 = "Computer Choice", heading3 = "User Choice"
				String heading4 = "Winner", heading 5 = "User Score", heading 6 = "Comp Score"
		String winner = null, userChose = null, compChose = null;
		System.out.println(
				"-----------------------------------------------------------------------------------------------\nYou have chosen to play Rock Paper Scissors normally");
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
			System.out.printf("%-s %s %s %s %s %s", heading1, heading2, heading3, heading4, heading5, heading6);
			for (game = 1; game <= 1; game++) { // Runs it once and then reset for next round
				if (userChoice == compChoice) { // Tie, user can choose to break the tie with a specific game or
												// continue without choosing
					System.out.print("\nTie");
					tieScore = oddAndEven(0);
					if (tieScore == 1) {// User wins if return value is 1 from the game
						userScore++;
						winner = "User";
						System.out.printf("%-s %s %-5s %s %s %s",round, compChose, userChose, winner, userScore, compScore);

					} else {// User loses if the return value is 0
						compScore++;
						winner = "Computer";
						System.out.printf("%-s %s %-5s %s %s %s",round, compChose, userChose, winner, userScore, compScore);

					}
					round++;

				} else if (userChoice == 'r' && compChoice == 's' || userChoice == 's' && compChoice == 'p'
						|| userChoice == 'p' && compChoice == 'r') {// User wins
					userScore++;
					winner = "User";
					System.out.printf("%-s %s %-5s %s %s %s",round, compChose, userChose, winner, userScore, compScore);


					round++;
				} else {// Comp wins
					compScore++;
					winner = "Computer";
					System.out.printf("%-s %s %-5s %s %s %s",round, compChose, userChose, winner, userScore, compScore);

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
	}

	public static int randRps() { // Random rock paper Scissors Game
		Scanner reader = new Scanner(System.in);
		int userScore = 0, compScore = 0;
		int gameWinner = 3, tieScore = 3;
		int round = 1, game = 1;
		char compChoice, tieBreaker, userChoice;
		String heading1 = "Round", heading2 = "Computer Choice", heading3 = "User Choice"
		String heading4 = "Winner", heading 5 = "User Score", heading 6 = "Comp Score"
		String winner = null, userChose = null, compChose = null;
		System.out.println(
				"-----------------------------------------------------------------------------------------------\nYou have chosen to play Rock Paper Scissors randomly");
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
			System.out.printf("%-s %s %s %s %s %s", heading1, heading2, heading3, heading4, heading5, heading6);
			for (game = 1; game <= 1; game++) { // Runs it once and then reset for next round
				if (userChoice == compChoice) { // Tie, user can choose to break the tie with a specific game or
												// continue without choosing
					System.out.print("\nTie");
					tieScore = oddAndEven(1);
					if (tieScore == 1) {// User wins if return value is 1 from the game
						userScore++;
						winner = "User";
						System.out.printf("%-s %s %-5s %s %s %s",round, compChose, userChose, winner, userScore, compScore);
					} else {// User loses if the return value is 0
						compScore++;
						winner = "Computer";
						System.out.printf("%-s %s %-5s %s %s %s",round, compChose, userChose, winner, userScore, compScore);

					}
					round++;

				} else if (userChoice =n= 'r' && compChoice == 's' || userChoice == 's' && compChoice == 'p'
						|| userChoice == 'p' && compChoice == 'r') {// User wins
					userScore++;
					winner = "User";
					System.out.printf("%-s %s %-5s %s %s %s",round, compChose, userChose, winner, userScore, compScore);


					round++;
				} else {// Comp wins
					compScore++;
					winner = "Computer";
					System.out.printf("%-s %s %-5s %s %s %s",round, compChose, userChose, winner, userScore, compScore);

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
	}// end rPS

	public static int oddAndEven(int rand) {
		char userChoiceOddEven, compChoiceOddEven;
		int userFinger = 3, compFinger = 3;
		String heading1 = "Round", heading2 = "Computer Choice", heading3 = "User Choice"
				String heading4 = "Winner", heading 5 = "User Score", heading 6 = "Comp Score"
		
		Scanner reader = new Scanner(System.in);
		if (rand == 0) {
			System.out.println(
					"\n-----------------------------------------------------------------------------------------------\nYou have chosen to the game of Odd or Even to break the tie");
		} else {
			System.out.println(
					"\n-----------------------------------------------------------------------------------------------\nThe game of odd or even was chosen randomly for you to break the tie");
		}
		// String finger = "ab"; // Comp chooses between 1-2 fingers
		int randIndexFinger = (int) (Math.random() * 2);
		// compFinger = finger.charAt(randIndexFinger);
		compFinger = randIndexFinger;
		// System.out.println("Computers finger choice is " +compFinger);
		do {
			System.out.println("Pick an odd or even outcome! Using \"O\" for odd and \"E\"!");
			userChoiceOddEven = reader.nextLine().charAt(0); // user picks their finger
		} while (userChoiceOddEven != 'o' && userChoiceOddEven != 'O' && userChoiceOddEven != 'e'
				&& userChoiceOddEven != 'E');
		if (userChoiceOddEven == 'e') {
			compChoiceOddEven = 'o';
		} else {
			compChoiceOddEven = 'e';
		}
		// System.out.println("User Choice " +userChoiceOddEven +" Comp Choice "
		// +compChoiceOddEven);
		do {
			System.out.println("Pick between 1-2 fingers to hold up!");
			userFinger = reader.nextInt();
		} while (userFinger < 1 || userFinger > 2);
		// System.out.println("user Finger " +userFinger +" Comp finger " +compFinger);
		// Step 5: IF userFinger == compFinger THEN Output "Even"
		if (userFinger == compFinger) {
			System.out.println("Even!");
			// Step 5.1: IF userChoice = 'e' Then +score and round winner ELSE loser
			if (userChoiceOddEven == 'e') {
				System.out.println("Winner!");
				System.out.println("Your score went up by 1!");
				System.out.print("Round\t\t   Computer Choice\t\t  User Choice\t\t  Winner\t\tUser Score\t\tComp Score");
				return 1;
			} else {
				System.out.println("Loser!");
				System.out.println("Computer score went up by 1!");
				System.out.print("Round\t\t   Computer Choice\t\t  User Choice\t\t  Winner\t\tUser Score\t\tComp Score");
				return 0;
			}
		}
		// Step 5.2 Output Odd if userFinger =/= compFinger
		else {
			System.out.println("Odd");
			// Step 5.2.1: IF userChoice = 'o' Then +score and round winner ELSE loser
			if (userChoiceOddEven == 'o') {
				System.out.println("Winner!");
				System.out.println("Your score went up by 1!");
				System.out.printf("%-s %s %s %s %s %s", heading1, heading2, heading3, heading4, heading5, heading6);
				return 1;
			} else {
				System.out.println("Loser!");
				System.out.println("Computer score went up by 1!");
				System.out.printf("%-s %s %s %s %s %s", heading1, heading2, heading3, heading4, heading5, heading6);
				return 0;
			}
		}
	}

	public static String toString(char c) {
		if (c == 'r') {
			return "Rock";
		} else if (c == 's') {
			return "Scissors";
		} else {
			return "Paper";
		}
	}
}// end class
