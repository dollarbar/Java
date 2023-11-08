/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: Sep 13, 2022
 
 * Description: Assignment #7
 
 * This program demonstrates the use of methods -
 
 * Both calling and invoking.

 */

import java.util.Scanner;

public class BerkezGlebAssignment7 {
	/************ MAIN ****************/
	public static void main(String[] args) {
		
		// constant previous two passwords
		final String PREVIOUS1 = "secret007";
		final String PREVIOUS2 = "your2eyes";
		
		// Conditions for while-loop
		boolean validPassword = false;
		int numberAttempts = 0;
		
		// MAIN WHILE LOOP
		while (validPassword == false && numberAttempts < 4) {
			// obtain user password
			System.out.println("Enter your password: ");
			String myPassword = getNewPassword();
			numberAttempts++;
			
			//test for length
			if (lengthTest(myPassword) == false) {
				printErrorMessage(1);
			}
			//test for no special characters
			else if (onlyLettersAndDigitsTest(myPassword) == false) {
				printErrorMessage(2);
			}
			//test for 1 to 3 digits
			else if (containsOneToThreeDigits(myPassword) == false) {
				printErrorMessage(3);
			}
			// test for identical previous 2 passwords
			else if (differentThanLastTwoPasswordsTest(PREVIOUS1, PREVIOUS2, myPassword) == false) {
				printErrorMessage(4);
			}
			// if myPassword passes all parameters
			else {
				System.out.println("Your password was successfully updated");
				validPassword = true;
			}
			if (numberAttempts > 3) {
				System.out.println("You've tried 4 times – password was not updated - good bye");
			}
		}//while loop
		
	}//main loop

	
	
	/************** METHODS *****************/ 
	// get new password method
	public static String getNewPassword() {
		Scanner input = new Scanner (System.in);
		String password = input.next();
		return password;
	}//getNewPassword method
	
	// test for password length method
	public static boolean lengthTest(String password) {
		int passwordLength = password.length();
		if (passwordLength < 5 || passwordLength > 16) {
			return false;
		}
		else {
			return true;
		}
	}//lengthTest
	
	// test for only letters and digits
	public static boolean onlyLettersAndDigitsTest(String password) {
		int characterNumber = 0;
		int lastCharacter = password.length()-1;
		boolean isLettorOrDigit = true;

		//isLetterOrDigit
		while (characterNumber <= lastCharacter) {
			
			if (Character.isLetterOrDigit(password.charAt(characterNumber)) == false) {
				isLettorOrDigit = false;
			}
			characterNumber++;
		}
		
		// return true or false for method
		if (isLettorOrDigit == false) {
			return false;
		}
		else {
			return true;
		}
	}// isLetterOrDigit method
	
	// test for 1 to 3 digits in password
	public static boolean containsOneToThreeDigits(String password) {
		int integerCount = 0;
		int characterNumber = 0;
		int lastCharacter = password.length()-1;
		
		// isDigit
		while (characterNumber <= lastCharacter) {
				
			if (Character.isDigit(password.charAt(characterNumber)) == true) {
				integerCount++;
			}
			characterNumber++;
		}
		
		if (integerCount > 2) {
			return true;
		}
		else {
			return false;
		}
	}//containsOneToThreeDigits method
	
	// different than last two passwords method
	public static boolean differentThanLastTwoPasswordsTest(String previousPassword1, String previousPassword2, String password) {
		// compare passwords
		if (password.compareTo(previousPassword1) == 0 || password.compareTo(previousPassword2) == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// error message method
	public static void printErrorMessage(int errorCode) {
		switch(errorCode) {
			case 1:
				System.out.println("Password does not meet requirement: must be between 6 and 15 characters");
				break;
			case 2:
				System.out.println("Password does not meet requirement: must not contain any special characters");
				break;
			case 3:
				System.out.println("Password does not meet requirement: must contain at least 1 digit and not more than 3");
				break;
			case 4:
				System.out.println("Password does not meet requirement: must be different than previous 2 passwords");
				break;
		}//switch
	}// end printErrorMessage error
}// Class	
