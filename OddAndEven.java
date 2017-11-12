/*Hyperlolo
 * 11/11/17
 * Odd and Even game used inside of RPS game
 */
package trainingRPSGames;

import java.util.Scanner;

public class OddAndEven {

	public static int oddAndEven() {
		char userChoiceOddEven, compChoiceOddEven;
		int userFinger = 3, compFinger = 3;
		String header1 = "Round", header2 = "Computer Chose", header3 = "User Chose";
		String header4 = "Winner", header5 = "User Score", header6 = "Computer Score";

		Scanner reader = new Scanner(System.in);
		// String finger = "ab"; // Comp chooses between 1-2 fingers
		int randIndexFinger = (int) ((Math.random() * 2)+1);
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
				return 1;
			} else {
				System.out.println("Loser!");
				System.out.println("Computer score went up by 1!");
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
				return 1;
			} else {
				System.out.println("Loser!");
				System.out.println("Computer score went up by 1!");
				return 0;
			}
		}
	}

}
