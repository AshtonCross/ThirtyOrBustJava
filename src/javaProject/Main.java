//////////////////////////////////////////////////
// Ashton Cross                                 //
// CSC 160 - Computer Science I - Section 680   //
// May 6th, 2022                                //
// Semester Final Project                       //
//////////////////////////////////////////////////


package javaProject;

import java.util.Scanner;

class Player {
	public String name;
	private int score;
	
	
	Player(String name) {
		this.name = name;
		this.score = 0;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int additionalScore) {
		this.score += additionalScore;
	}
}


public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		mainMenu(input);
		input.close(); // close this LAST
	}
	
	public static void mainMenu(Scanner input) {
		System.out.println("+----------------------------+");
		System.out.println("|   Welcome to 30 or Bust!   |");
		System.out.println("+----------------------------+\n");
		
		System.out.println("         1 - Start");
		System.out.println("         2 - Help");
		System.out.println("         3 - Exit");
		
		boolean validInput = false;
		
		// ask for input until valid
		while(!validInput) {
			System.out.print(" > ");
			
			
			String menuSelection = input.nextLine()
					.trim()								// remove any possible whitespace
					.toLowerCase();						// make it lower case so it is easier to handle
			//input.close();
			
			
			switch (menuSelection) {
			
			case "1":
			case "start":
				playGame();
				validInput = true;
				break;
			
			case "2":
			case "help":
				helpMenu();
				mainMenu(input);
			
			case "3":
			case "exit":
				validInput = true;
				break;
				
			default:
				System.out.println("Please enter valid input.");
				break;
			}	
			
		}
	}
	
	public static void helpMenu() {
		System.out.println("30 or Bust is a dice game played with two players.\n"
				+ "Players take turns rolling two dice and can choose to add either the total of the two dice, or\n"
				+ "either dice's individual face value to their total score.\n"
				+ "The first player to reach a score of 30 wins.\n"
				+ "Any higher than that however, and their score gets set back to zero!\n\n"
				+ "Press ENTER to return to the main menu.");
		
		Scanner input = new Scanner(System.in);
		input.nextLine();
	}
	
	public static String getPlayerName(String player) {
		System.out.println("Hello Player " + player + "!");
		System.out.println("What would you like your name to be?");
		System.out.print("> ");
		
		Scanner input = new Scanner(System.in);
		String desiredName = input.nextLine();
		
		return desiredName;
	}
	
	public static void playGame() {
		// set up player objects
		Player playerOne = new Player(getPlayerName("1"));
		Player playerTwo = new Player(getPlayerName("2"));
		
		int round = 1;
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.println("Welcome to round #" + round + "!\n");
			
			// player 1 
			System.out.println("Hey " + playerOne.name + "! Right now, your score is " + playerOne.getScore() + "!\n");
			
			if (playerOne.getScore() >= 24) {
				System.out.println("Be very careful!");
			}
			
			System.out.println("Your score is " + (30 - playerOne.getScore()) + " points away from 30!\n");
			System.out.println("Press ENTER to roll!");
			
			input.nextLine();
			
		
			System.out.println("Your dice are...");
			int dieOne = (int)(Math.random() * 6 + 1);
			int dieTwo = (int)(Math.random() * 6 + 1);
			
			System.out.println("Die one: " + dieOne);
			System.out.println("and...");
			System.out.println("Die two: " + dieTwo + "\n");
			
			System.out.println("Together, that makes " + (dieOne + dieTwo) + "!");
			
			System.out.println("Would you like to add DIEONE, DIETWO, or the TOTAL to your score?");
			
			if (round == 1)
				System.out.println("Enter desired action. (Possible actions are written in caps)");
			
			// player 1 action selection 
			while (true) {
				System.out.print("> ");
				String action = input.nextLine().toLowerCase();
				
				if (action.equals("dieone")) {
					playerOne.addScore(dieOne);
					break;
				} else if (action.equals("dietwo")) {
					playerOne.addScore(dieTwo);
					break;
				} else if (action.equals("total")) {
					playerOne.addScore(dieOne + dieTwo);
					break;
				} else {
					System.out.println("Not valid action.");
				}
			}
			
			System.out.println("Your new score is " + playerOne.getScore() + ".");
						
			// check the player scores
			if (playerOne.getScore() == 30) {
				System.out.println(playerOne.name + " wins!!!");
				break;
			} 
			
			if (playerOne.getScore() > 30) {
				System.out.println("\n\nSorry " + playerOne.name + ", your score is over 30!\nBack to square one!");
				playerOne.setScore(0);
				System.out.println(playerOne.name + "'s score is now equal to 0 :(\n");
			}
			
			System.out.println("Press ENTER for " + playerTwo.name + "'s turn to begin.");
			input.nextLine();
			System.out.println("\n\n\n");
			
			
			// player 2
			System.out.println("Hey " + playerTwo.name + "! Right now, your score is " + playerTwo.getScore() + "!\n");
			
			if (playerTwo.getScore() >= 24) {
				System.out.println("Be very careful!");
			}
			
			System.out.println("Your score is " + (30 - playerTwo.getScore()) + " points away from 30!\n");
			System.out.println("Press ENTER to roll!");
			
			input.nextLine();
			
		
			System.out.println("Your dice are...");
			dieOne = (int)(Math.random() * 6 + 1);
			dieTwo = (int)(Math.random() * 6 + 1);
			
			System.out.println("Die one: " + dieOne);
			System.out.println("and...");
			System.out.println("Die two: " + dieTwo + "\n");
			
			System.out.println("Together, that makes " + (dieOne + dieTwo) + "!");
			
			System.out.println("Would you like to add DIEONE, DIETWO, or the TOTAL to your score?");
			
			if (round == 1)
				System.out.println("Enter desired action. (Possible actions are written in caps)");
			
			// player 2 action selection 
			while (true) {
				System.out.print("> ");
				String action = input.nextLine().toLowerCase();
				
				if (action.equals("dieone")) {
					playerTwo.addScore(dieOne);
					break;
				} else if (action.equals("dietwo")) {
					playerTwo.addScore(dieTwo);
					break;
				} else if (action.equals("total")) {
					playerTwo.addScore(dieOne + dieTwo);
					break;
				} else {
					System.out.println("Not valid action.");
				}
			}
			
			System.out.println("Your new score is " + playerTwo.getScore() + ".");
			
			// check the player scores
			if (playerTwo.getScore() == 30) {
				System.out.println(playerTwo.name + " wins!!!");
				break;
			} 
						
			if (playerTwo.getScore() > 30) {
				System.out.println("\nSorry " + playerTwo.name + ", your score is over 30!\nBack to square one!");
				playerOne.setScore(0);
				System.out.println(playerOne.name + "'s score is now equal to 0 :(\n");
			}
			
			
			System.out.println("Press ENTER for the next round to begin.");
			input.nextLine();
			System.out.println("\n\n\n");
			
			round++;
		}

		mainMenu(input);
	}
}
