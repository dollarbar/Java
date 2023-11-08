import java.util.Scanner;

/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: Sep 8, 2022
 
 * Description: Assignment #2
 
 * This program demonstrates the use of variables

 * And computations while incorporating Scanner object.

 */

public class BerkezGlebAssignment2 {

	public static void main(String[] args) {
		// Import java.util
		
		// Create Scanner Object
		Scanner input = new Scanner(System.in);
		
		// Ask user for details of bank and CDs
		// Set up output of user input values
		System.out.print("Enter name of bank: ");
		String bankName = input.nextLine();
		
		// Input for CD #1
		System.out.println("\n\n\nCD #1 Information:\n");
		System.out.println("-----------------------------");
		
		System.out.print("\nEnter principle deposited: ");
		double cd1Principle = input.nextDouble();
		
		System.out.print("\nEnter annual interest rate: ");
		double cd1Rate = input.nextDouble();
		
		System.out.print("\nEnter number of years: ");
		int cd1Years = input.nextInt();
		
		// Input for CD #2
		System.out.println("\n\n\nCD #2 Information: ");
		System.out.println("\n-----------------------------\n");
		
		System.out.print("Enter principle deposited: ");
		double cd2Principle = input.nextDouble();
		
		System.out.print("\nEnter annual interest rate: ");
		double cd2Rate = input.nextDouble();
		
		System.out.print("\nEnter number of years: ");
		int cd2Years = input.nextInt();
		
		// Create Title Banner with bankName showing
		System.out.print("\n\n\n\n**************************************************************************************************");
		System.out.println("\n\n\t\t\tCertificate of Deposits");
		System.out.printf("\n\t\t\t     %s", bankName);
		System.out.println("\n\n****************************************************************************************************\n");
		
		// Variables and Expressions of needed information
		final int numPeriods = 1;
		cd1Rate = cd1Rate/100;
		cd2Rate = cd2Rate/100;
		
		// Compound formula: A = P(1 + r/n)^(nt)
		
		// CD #1
		double cd1_baseExpression = (1 + cd1Rate / numPeriods);
		int cd1_exponent = numPeriods * cd1Years;
		double cd1_Worth = cd1Principle * Math.pow(cd1_baseExpression, cd1_exponent);
		double cd1_interestEarned = cd1_Worth - cd1Principle;
		
		// CD #2
		double cd2_baseExpression = (1 + cd2Rate / numPeriods);
		int cd2_exponent = numPeriods * cd2Years;
		double cd2_Worth = cd2Principle * Math.pow(cd2_baseExpression, cd2_exponent);
		double cd2_interestEarned = cd2_Worth - cd2Principle;
		
		// Totals
		double totalPrinciple = cd1Principle + cd2Principle;
		double totalInterestEarned = cd1_interestEarned + cd2_interestEarned;
		double totalFinalAmount = cd1_Worth + cd2_Worth;
		
		// Formatted Table Output
		System.out.println("\n\n\t\tPrinciple \tRate \tYears \tInterest Earned \tFinale Amount");
		System.out.println("\n---------------------------------------------------------------------------------------\n");
		System.out.printf("CD #1\t\t%7.2f \t%2.2f \t%d \t%3.2f \t\t\t%7.2f\n\n", cd1Principle, cd1Rate*100, cd1Years, cd1_interestEarned, cd1_Worth);
		System.out.printf("CD #2\t\t%7.2f \t%2.2f \t%d \t%3.2f \t\t\t%7.2f\n\n", cd2Principle, cd2Rate*100, cd2Years, cd2_interestEarned, cd2_Worth);
		System.out.println("-----------------------------------------------------------------------------------------\n");
		System.out.printf("Totals \t\t%7.2f \t\t\t%3.2f \t\t\t%7.2f\n\n", totalPrinciple, totalInterestEarned, totalFinalAmount);
	}

}
