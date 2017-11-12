package trainingRPSGames;

import java.util.Scanner;

public class Nim {

	public static void main(String[] args) {
	int winner = nim();
	//System.out.println("Winner is " +winner);
	}
	public static int nim() {
		Scanner input = new Scanner(System.in);
		int toothpicks = 23;
		int userPick = 0;
		int userTurn = 1;
		int winner = 3;
		do {
			if (userTurn == 1) {
				int userResult[] = usersTurn(toothpicks);
				userPick = userResult[0];
				toothpicks = userResult[1];
				userTurn--;
			}
			if (toothpicks <= 4) {
				winner = endgame(userTurn, toothpicks);
				return winner;

			}
			if (userTurn == 0) {
				int compResult[] = compsTurn(toothpicks, userPick);
				userTurn = compResult[0];
				toothpicks = compResult[1];
			}
			if (toothpicks <= 4) {
				winner = endgame(userTurn, toothpicks);
				return winner;
			}
		} while (toothpicks > 4);
		winner = endgame(userTurn, toothpicks);
		return winner;
	}
	
	public static int[] compsTurn(int toothpicks, int userPick) {
		int compPick = 4 - userPick;
		toothpicks = toothpicks - compPick;
		if (compPick == 1) {
			System.out.println("The computer picks out " + compPick + " toothpick out of the pile.\n\n "
					+ toothpicks + " toothpicks left.\n");
		}
		System.out.println("The computer picks out " + compPick + " toothpicks out of the pile.\n\n "
				+ toothpicks + " toothpicks left.\n");
		int userTurn = 1;
		return new int[] { userTurn, toothpicks };
	}

	public static int[] usersTurn(int toothpicks) {
		Scanner input = new Scanner(System.in);
		int userPick;
		do {
			System.out.println("\n\nPlease pick 1-3 toothpicks that you would like to withdraw from the pile of "
					+ toothpicks + " toothpicks\n");
			userPick = input.nextInt();
			if (userPick < 1 || userPick > 3) {
				System.out.println("Please enter a number between 1-3.");
			}
		} while (userPick < 1 || userPick > 3);
		toothpicks = toothpicks - userPick;
		System.out.println( toothpicks + " toothpicks left.\n");
		return new int[] { userPick, toothpicks };

	}
	
	public static int endgame(int userTurn, int toothpicks) {
		int winner = 3;
		do {
			int compPick;
			if (userTurn == 0 && toothpicks == 4) {
				compPick = 3;
				toothpicks = toothpicks - compPick;
				System.out.println("The computer picks out " + compPick + " toothpicks out of the pile.\n\n"
						+ toothpicks + " toothpick left\n");
				userTurn++;
			}
			if (userTurn == 0 && toothpicks == 3) {
				compPick = 2;
				toothpicks = toothpicks - compPick;
				System.out.println("The computer picks out " + compPick + " toothpicks out of the pile.\n\n"
						+ toothpicks + " toothpick left\n");
				userTurn++;
			}
			if (userTurn == 0 && toothpicks == 2) {
				compPick = 1;
				toothpicks = toothpicks - compPick;
				System.out.println("The computer picks out " + compPick + " toothpicks out of the pile.\n\n"
						+ toothpicks + " toothpick left\n");
				userTurn++;
			}
			if (userTurn == 0 && toothpicks == 1) {
				compPick = 1;
				toothpicks = toothpicks - compPick;
				System.out.println("The computer picks out " + compPick + " toothpick out of the pile.\n\n"
						+ toothpicks + " toothpicks left.\n-----------------------------------------------------------------------------------------------\nThe computer loses! Congratulations!");
				winner = 1;
			}
			if (userTurn == 1) {
				int userPick;
				do {
					Scanner input = new Scanner(System.in);
					System.out.println("There are " + toothpicks
							+ " toothpicks left\nPlease pick 1-3 tooth picks to take out of the pile.");
					userPick = input.nextInt();
					if (userPick < 1 || userPick > 3) {
						System.out.println("Please pick a valid number between 1-3");
					}
				} while (userPick < 1 || userPick > 3);
				toothpicks = toothpicks - userPick;
				if (toothpicks == -1 || toothpicks == -2) {
					System.out.println(
							"You lose, there are 0 toothpicks left in the pile.\n-----------------------------------------------------------------------------------------------\nThe computer wins! Good luck next time!");
					winner = 0;
				}
				System.out.println("There are " + toothpicks + " toothpicks left in the pile\n");
				if (toothpicks == 0) {
					System.out.println("You picked out the last toothpick!\n-----------------------------------------------------------------------------------------------\nThe computer wins!");
					winner = 0;
				} else
					userTurn--;
			}
		} while (toothpicks > 0);
		return winner;

	}
}