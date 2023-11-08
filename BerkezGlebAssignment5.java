/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: Sep 29, 2022
 
 * Description: Assignment #5
 
 * This program uses a while loop to

 * output statistics for an uncertain amount of inputs

 */
/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: Sep 1, 2022
 
 * Description: Assignment #1
 
 * This program demonstrates that I understand basic program structure by
  
 * printing a couple paragraphs that tell the instructor what I’m passionate
        
 * about.  It also gives a little practice with arithmetic in Java.

 */

import java.util.Scanner;

public class BerkezGlebAssignment5 {

	public static void main(String[] args) {
		// Prompt user for unspecified number of sales
		Scanner input = new Scanner (System.in);
		System.out.println("Enter amount of sales \n");
		
		// Variables for statistics 
		int salesAmount = 0;
		double salesSmallest = 0;
		double salesLargest = 0;
		double salesSumTotal = 0;
		
		int salesAmount_500 = 0;
		int salesAmount_500_2000 = 0;
		int salesAmount_2000 = 0;
		
		// Variables for bar chart
		String barChart = "";
		int salesNumber = 1;
		
		// Create first read of input to initialize salesSmallest
		double salesInput = input.nextDouble();
		salesSmallest = salesInput;
		
		// Perform while loop
		while (salesInput != -1) {
			
			// CREATE BAR CHART WITH 1 ASTERICK REPRESENTING $100 IN SALES
			double doubleAsterick = salesInput / 100;
			final int NUM_ASTERICK = (int)doubleAsterick;
			String stringAsterick = "*";
			
			// Create string for each sale and increment to barChart
			String repeatAsterick = stringAsterick.repeat(NUM_ASTERICK);
			String saleInfo = "Sale #" + salesNumber + ": " + repeatAsterick + "\n";
			barChart += saleInfo;
			
			
			// If statement to ignore the -1 entered to exit while loop
			if (salesInput != -1) {

				salesAmount += 1;
				salesNumber += 1;
				
				// Find smallest and largest sales amount
				if (salesSmallest > salesInput) { 		// SMALLEST
					salesSmallest = salesInput;
				}
				if (salesLargest < salesInput) {
					salesLargest = salesInput;			// LARGEST
				}
				
				// Increment sum total of sales
				salesSumTotal += salesInput;
				
				// Find amount of sales for required parameters
				if (salesInput < 500) {		// LESS THAN 500
					salesAmount_500 += 1;
				}
				else if (salesInput >= 500 && salesInput <= 2000) {
					salesAmount_500_2000 += 1;		// MIDDLE
				}
				else if (salesInput > salesAmount_2000) {
					salesAmount_2000 += 1;		// OVER 2000
				}
				salesInput = input.nextDouble();
			} // end if salesInput != -1 statement
			
		} // end sales input while loop
		
		double salesAverage = salesSumTotal / salesAmount;
		
		// BAR CHART
		System.out.println(barChart); 
		
		
		// DISPLAY REQUIRED STATISTICS
		System.out.printf("\nHow many sales amounts were entered? %d", salesAmount);
		System.out.printf("\nWhat is the smallest sales amount entered? $%5.2f", salesSmallest);
		System.out.printf("\nWhat is the largest sales amount entered? $%5.2f", salesLargest);
		System.out.printf("\nWhat is the sum total of all sales entered? $%6.2f", salesSumTotal);
		System.out.printf("\nWhat is the average amount of sales? $%5.2f", salesAverage);
		System.out.printf("\nWhat is the amount of sales less than $500? %d", salesAmount_500);
		System.out.printf("\nWhat is the amount of sales between $500 and $2000? %d", salesAmount_500_2000);
		System.out.printf("\nWhat is the amount of sales greater than $2000? %d", salesAmount_2000);
	} // static void

} // class
