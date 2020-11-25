package com.riddle;

import java.util.Scanner;
import java.util.HashMap;

/*
 * The purpose of this project is to create a riddle game. Upon successful execution, the program will provide a user with three riddles and three possible solutions for each riddle.
 * The user must solve the current riddle before moving on to the next. Only one of the three possible solutions is the correct solution. 
 */

public class Riddle {
	
	// Creates global static scanner for both methods to use.
	static Scanner userInput = new Scanner(System.in);
	
	public static void loginFeature() {
		
		// Declares and initializes variables.
		boolean userLoggedIn = false;
		boolean passwordCorrect = false;
		boolean accountCreated;
		String userMenuChoice = "";
		String userName = "";
		String userPassword = "";
		
		// Stores user's username and password.
		HashMap<String, String> accountCredentials = new HashMap<String, String>();
		
		// Loop to allow user to create account and login.
		while (userLoggedIn == false) {
			System.out.println("Would you like to login or create an account?");
			System.out.println("Please type 'login' or 'create account' as they are displayed here.");
			userMenuChoice = userInput.nextLine();
			// Resets create account loop so user can create multiple accounts.
			accountCreated = false;
			
			// Checks that user entered 'login'.
			if (userMenuChoice.equals("login")) {
				System.out.println("Enter your username:");
				userName = userInput.nextLine();
				
				// Checks that username user entered is stored in accountCredentials.
				if (accountCredentials.containsKey(userName)) {
					System.out.println("Enter your password:");
					userPassword = userInput.nextLine();
					
					// Loop to allow user multiple attempts to enter password.
					while (passwordCorrect == false) {
						if (accountCredentials.get(userName).equals(userPassword)) {
							System.out.println("Login successful.");
							passwordCorrect = true;
							userLoggedIn = true;
						}
						else {
							System.out.println("Password incorrect.");
						}
					}
				}
				else {
					// Prints if user did not enter a username that matches a username stored in accountCredentials.
					System.out.println("Error: the username you entered does not match an existing account.");
				}
			}
			
			// Checks that user entered 'create account'.
			if (userMenuChoice.equals("create account")) {
				// Loop to allow user multiple attempts to enter a username in case desired username(s) is already taken.
				while (accountCreated == false) {
					System.out.println("Enter your desired username:");
					userName = userInput.nextLine();
					
					// Checks if user's entered username is already in accountCredentials.
					if (accountCredentials.containsKey(userName)) {
						System.out.println("Sorry, that username is already taken.");
					}
					else {
						System.out.println("Create password:");
						userPassword = userInput.nextLine();
						// Stores user's login information in accountCredentials.
						accountCredentials.put(userName, userPassword);
						System.out.println("Account created successfully. Return to menu and login.");
						accountCreated = true;
					}
				}
			}
		}
		return;
	}

	public static void main(String[] args) {
		
		// Defines and initializes program variables.
		String userAnswer = "";
		boolean answerCorrectOne = false;
		boolean answerCorrectTwo = false;
		boolean answerCorrectThree = false;
		
		// Calls the login feature method, requiring the user to login before they can play the riddle game.
		Riddle.loginFeature();
		
		
		// Prints a message the first time the program is started that introduces players to the game and shows them how to play.
		System.out.println("Welcome to The Riddle Game!");
		System.out.println("There are multiple choices to each riddle. Type the answer you think is correct and press Enter!");
		System.out.println("Okay, let's begin!");
		
		// Prints the first riddle and the three possible solutions for it.
		System.out.println("1# Riddle: The more you take, the more you leave behind. What am I?");
		System.out.println("Footsteps");
		System.out.println("Photos");
		System.out.println("Cookies");
		
		/*
		 * This is the logic for the first riddle.
		 * The while loop repeats until the correct answer is entered.
		 * Each time the loop executes, the user is prompted to enter an answer, and the program tells them if they are correct or wrong.
		 */
		while (answerCorrectOne != true) {
			System.out.println("Enter your answer now:");
			userAnswer = userInput.nextLine();
			
			if (userAnswer.equals("Footsteps")) {
				System.out.println("Correct! Way to go! Let's move on to the next riddle.");
				answerCorrectOne = true;
			} else {
				System.out.println("Sorry! That is the wrong answer. Try again!");
			}
		}
		
		
		// Prints the second riddle and the three possible solutions for it.
		System.out.println("2# Riddle: What comes once in a minute, twice in a moment, but never in a thousand years?");
		System.out.println("M");
		System.out.println("Wishes");
		System.out.println("Miracles");
		
		/*
		 * This is the logic for the second riddle.
		 * The while loop repeats until the correct answer is entered.
		 * Each time the loop executes, the user is prompted to enter an answer, and the program tells them if they are correct or wrong.
		 */
		while (answerCorrectTwo != true) {
			System.out.println("Enter your answer now:");
			userAnswer = userInput.nextLine();
			
			if (userAnswer.equals("M")) {
				System.out.println("Correct! Way to go! Let's move on to the next riddle.");
				answerCorrectTwo = true;
			} else {
				System.out.println("Sorry! That is the wrong answer. Try again!");
		    }
		}
		
		// Prints the third riddle and the three possible solutions for it.
		System.out.println("3# Riddle: What is more useful when it is broken?");
		System.out.println("Eggs");
		System.out.println("Hammer");
		System.out.println("Bucket");
		
		/*
		 * This is the logic for the third riddle.
		 * The while loop repeats until the correct answer is entered.
		 * Each time the loop executes, the user is prompted to enter an answer, and the program tells them if they are correct or wrong.
		 */
		while (answerCorrectThree != true) {
			System.out.println("Enter your answer now:");
			userAnswer = userInput.nextLine();
					
			if (userAnswer.equals("Eggs")) {
				System.out.println("Correct! Wow, you solved every riddle!");
				answerCorrectThree = true;
			} else {
				System.out.println("Sorry! That is the wrong answer. Try again!");
			}
		}
		
		// Closes global scanner.
		userInput.close();
		return;
	}
}
