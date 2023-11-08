import java.util.Scanner;

/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: Sep 15, 2022
 
 * Description: Assignment #3
 
 * This program demonstrates the use of boolean statements.

 */

public class BerkezGlebAssignment3 {
	

	public static void main(String[] args) {
		
		// Create Scanner Object
		Scanner input = new Scanner(System.in);
		
		// Print display of hotels and their prices per night
		System.out.println("Welcome to CS1150 Hotels\n\n");
		System.out.println("Option   Hotel\t\t Room Rate\n");
		System.out.println("-------------------------------------------\n");
		System.out.println("1\t Best Western\t $134.00");
		System.out.println("2\t Hyatt\t\t $152.00");
		System.out.println("3\t Hilton\t\t $254.00");
		System.out.println("4\t Wyndham\t $295.00\n\n");
		
		// Declare room rate variables
		final double Best_Western_Fare = 134.00;
		final double Hyatt_Fare = 152.00;
		final double Hilton_Fare = 254.00;
		final double Wyndham_Fare = 295.00;
		
		// Declare taxes and fees as percentage
		final double Taxes_Fees = .125; 
		
		// Prompt user and user input for hotel option
		System.out.print("Hotel to book: select option 1, 2, 3, or 4: \n");
		int hotelOption = input.nextInt();
		
		
		
		if (hotelOption > 0 && hotelOption < 5) {
			
			// Prompt user and user input for number of nights 
			System.out.print("How many nights (1 to 14)? ");
			int numNights = input.nextInt();
			
			
			if (numNights > 0 && numNights < 15 ) {
				
				// Process hotel costs
				// Declare hotel name
				String hotelName = "";
				
				double totalCost = 0; 
				if (hotelOption == 1) {
					totalCost = Best_Western_Fare * (1 + Taxes_Fees) * numNights;
					hotelName = "Best Western";
				}
				else if (hotelOption == 2) {
					totalCost = Hyatt_Fare * (1 + Taxes_Fees) * numNights;
					hotelName = "Hyatt";
				}
				else if (hotelOption == 3) {
					totalCost = Hilton_Fare * (1 + Taxes_Fees) * numNights;
					hotelName = "Hilton";
				}
				else if (hotelOption == 4) {
					totalCost = Wyndham_Fare * (1 + Taxes_Fees) * numNights;
					hotelName = "Wyndham";
				}
				
				// Display choice of hotel, cost before fees, taxes and fees, and total cost
				System.out.println("\n----------------------------------\n");
				System.out.printf("Hotel\t\t %s\n\n", hotelName);
				System.out.println("-----------------------------------\n");
				System.out.printf("%d nights\t $ %3.2f\n\n", numNights, (totalCost /(1 + Taxes_Fees)));					
				System.out.printf("Taxes and Fees\t $ %3.2f\n\n", (totalCost/(1 + Taxes_Fees)) * Taxes_Fees);
				System.out.println("-----------------------------------\n");
				System.out.printf("Total cost\t $ %3.2f", totalCost);
			}
			else {
				System.out.println("Invalid number of nights");
			}
		}
		else {
			System.out.println("Invalid hotel option");
		}
		
	}

}
