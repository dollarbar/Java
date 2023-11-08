
/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: Sep 6, 2022
 
 * Description: Assignment #6
 
 * This program demonstrates that I can use while and for loops
 
 * With proper breaks To prompt a user a number of times and display
 
 * The results of the inputs

 */
import java.util.Scanner;

public class BerkezGlebAssignment6 {

	public static void main(String[] args) {
		// Initializing constant variables
		final String POP_TART_STRING = "Pop Tarts";
		final String PRETZELS_STRING = "Pretzels";
		final String FUNYUNS_STRING = "Funyuns";
		final double POP_TART_PRICE = 0.90;
		final double PRETZELS_PRICE = 0.70;
		final double FUNYUNS_PRICE = 1.50;
		
		double poptartTotal = 0;
		double pretzelsTotal = 0;
		double funyunsTotal = 0;
		
		int poptartCounter = 0;
		int pretzelsCounter = 0;
		int funyunsCounter = 0;
									///// DISPLAY MENU /////
		final String DISPLAY_MENU = "***************************************\n" + 
							"\tSnack Machine\n" + "***************************************\n" + 
							"Pop Tarts\tPop Tarts\tPop Tarts" +
							"\n1A  $" + POP_TART_PRICE + "0\t1B  $" + POP_TART_PRICE + "0\t1C  $" + POP_TART_PRICE + 
							"0\n-----------------------------------------\n" + 
							"Pretzels\tPretzels\tPretzels\n" + 
							"2A  $" + PRETZELS_PRICE + "0\t2B  $" + PRETZELS_PRICE + "0\t2C  $" + PRETZELS_PRICE +
							"0\n-----------------------------------------\n" + 
							"Funyuns\t\tFunyuns\t\tFunyuns" + 
							"\n3A  $" + FUNYUNS_PRICE + "0\t3B  $" + FUNYUNS_PRICE + "0\t3C  $" + FUNYUNS_PRICE + 
							"0\n-----------------------------------------";
									///// DISPLAY MENU /////
		
		System.out.println(DISPLAY_MENU);
		Scanner input = new Scanner (System.in);
		boolean inService = true; // boolean condition for running the machine
		
		while (inService) {
			System.out.println("\nHow many snacks would you like? Limit is 3: ");
			int snackNumber = input.nextInt();
			
			// Validate snackNumber is 3 or less
			while ((snackNumber > 3 || snackNumber < 0) && snackNumber != 999) {
				System.out.println("Invalid entry. Enter number between 1 and 3: ");
				snackNumber = input.nextInt();
			} // End while-loop validator 
			
			// if statement to separate running machine and shutdown mode
			if (snackNumber != 999) {
				
				// Prompt user for the snackSelection for each snackNumber
				for (int i = 0; i < snackNumber; i++) {
					System.out.println("\nEnter snack selection: ");
					String snackSelection = input.next();
				
					snackSelection = snackSelection.toUpperCase();
					char firstChar = snackSelection.charAt(0);
					char secondChar = snackSelection.charAt(1);
					
					// Declare snackSelection to snackItem and snackPrice
					String snackItem = "";
					double snackPrice = 0;
					switch (snackSelection) {
						case "1A": case "1B": case "1C":
							snackItem = POP_TART_STRING;
							snackPrice = POP_TART_PRICE;
							poptartTotal = poptartTotal + POP_TART_PRICE;
							poptartCounter++;
							break;
						case "2A": case "2B": case "2C":
							snackItem = PRETZELS_STRING;
							snackPrice = PRETZELS_PRICE;
							pretzelsTotal = pretzelsTotal + PRETZELS_PRICE;
							pretzelsCounter++;
							break;
						case "3A": case "3B": case "3C":
							snackItem = FUNYUNS_STRING;
							snackPrice = FUNYUNS_PRICE;
							funyunsTotal = funyunsTotal + FUNYUNS_PRICE;
							funyunsCounter++;
							break;
						
					} // END switch case
					
					// Validate snackSelection
					while (snackSelection.length() != 2 || firstChar < '1' || firstChar > '3' || secondChar < 'A' || secondChar > 'C') {
						System.out.println("Invalid entry. Enter 1A-1C, 2A-2C, or 3A-3C");
						snackSelection = input.next();
						snackSelection = snackSelection.toUpperCase();
						firstChar = snackSelection.charAt(0);
						secondChar = snackSelection.charAt(1);
					} // END while-loop validator
					
					// Display Individual Snack Receipt
					final String SNACK_RECEIPT = "----------------------------------------\n" + 
												 "---------Selection" + snackSelection + "-------------------\n" + 
												 "Snack Item: " + snackItem + "\nSnack Price: $" + snackPrice + 
												 "0\n------------------------------------------\n";
					System.out.println(SNACK_RECEIPT);
					System.out.println(DISPLAY_MENU);
								
					 
				} // END for statement iterating through snackNumber
				
				System.out.println("----------------------------------\nThank you for your business!\n----------------------------------");
				
			} // END if statement 
			else {
				// IF snackNumber == 999, Ask and validate password
				System.out.println("Enter Password: ");
				String password = input.next();
				while (!password.equals("COOKIES")) {
					System.out.println("Incorrect Password. Try again");
					password = input.next();
				}
				inService = false;
			}
		} // END While loop inService
	
		// final results while vending machine was running
		double totalSales = poptartTotal + pretzelsTotal + funyunsTotal;
		int totalSnacks = poptartCounter + pretzelsCounter + funyunsCounter;
		
		System.out.printf("Total sales: $%3.2f\n", totalSales);
		System.out.printf("Total Number Snacks Sold: %d\n", totalSnacks);
		System.out.printf("%d poptarts\n", poptartCounter);
		System.out.printf("%d pretzels\n", pretzelsCounter);
		System.out.printf("%d funyuns\n", funyunsCounter);
		
	} // public Static
	
} // public Class
