import java.util.Scanner;

/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: Sep 21, 2022
 
 * Description: Assignment #4
 
 * This program is a powerball game that selects
 
 * a winner based on randomly generated characters.

 */
public class BerkezGlebAssignment4 {

	
	public static void main(String[] args) {
		
		// Prompt user for two letters A to Z non-case sensitive
		System.out.println("Enter two letters between A and Z: ");
		Scanner input = new Scanner (System.in);
		String lettersInput = input.next();
		
		// Convert characters to upper-case and then to integers
		// This is to validate the integer to the ASCII encoding for the alphabet
		char char_1 = lettersInput.charAt(0); 
		char char_2 = lettersInput.charAt(1);
		char upperChar_1 = Character.toUpperCase(char_1);
		char upperChar_2 = Character.toUpperCase(char_2);
		final int INPUT_CHAR_1 = (int)upperChar_1;
		final int INPUT_CHAR_2 = (int)upperChar_2;
		
		// Validate for length of two characters
		int lettersLength = lettersInput.length();
		if (lettersLength != 2) {
			System.out.println("Invalid entry - need 2 letters between A and Z for this special Powerball");
			return;
		}
		else {	
			if (INPUT_CHAR_1 < 65 || INPUT_CHAR_1 > 90 || INPUT_CHAR_2 < 65 || INPUT_CHAR_2 > 90) {	
				System.out.println("Invalid entry - need 2 letters between A and Z for this special Powerball");
				return;
			}
		}
		
		// Prompt user for a number 0 to 22
		System.out.println("Enter one number between 1 and 22: ");
		final int NUMBER_INPUT = input.nextInt();
		
		// Validate input is only one number and between 1 and 22
		if (NUMBER_INPUT < 1 || NUMBER_INPUT > 22) {
			System.out.println("Needs to be a number between 1 and 22 for this special Powerball");
			return;
		}
		
		
		// Display user's Powerball ticket in capital letters and number as third element
		System.out.printf("Customer Lottery Ticket\n%c %c %d\n\n", INPUT_CHAR_1, INPUT_CHAR_2, NUMBER_INPUT);
		
		// Generate a random Powerball ticket with two letters and a number
		// Generate two random letters
		int lettersGen_1 = 'A' + (int)(Math.random() * 26);
		int lettersGen_2 = 'A' + (int)(Math.random() * 26);
		final int NUMBER_GEN = (int)(Math.random() * 23);
		
		// Convert generated letters into characters
		char charGen_1 = (char)lettersGen_1;
		char charGen_2 = (char)lettersGen_2;
		
		// Convert characters into upper-case
		final char UPPER_CHAR_GEN_1 = Character.toUpperCase(charGen_1);
		final char UPPER_CHAR_GEN_2 = Character.toUpperCase(charGen_2);
		
		// Display the lottery ticket
		System.out.printf("Powerball Lottery Ticket\n%c %c %d\n\n", UPPER_CHAR_GEN_1, UPPER_CHAR_GEN_2, NUMBER_GEN);
		
		// Use nested if-statements to display the customer's reward
		if (INPUT_CHAR_1 == UPPER_CHAR_GEN_1 && INPUT_CHAR_2 == UPPER_CHAR_GEN_2 && NUMBER_INPUT == NUMBER_GEN) {
			System.out.println("Jackpot");
		}
		
		else {
			if (INPUT_CHAR_1 == UPPER_CHAR_GEN_1 && INPUT_CHAR_2 == UPPER_CHAR_GEN_2) {
				System.out.println("You Win $100");
			}
			else {
				if (INPUT_CHAR_1 == UPPER_CHAR_GEN_1 || INPUT_CHAR_2 == UPPER_CHAR_GEN_2) {
					System.out.println("You Win $40");
					}
					else {
						if (NUMBER_INPUT == NUMBER_GEN) {
							System.out.println("You Win $20");
						}
						else {
							System.out.println("Your Lottery Ticket Did Not Win");
						
						} // End fourth else
					} // End third else
			} // End second else
		} // End first else		
	}
}
