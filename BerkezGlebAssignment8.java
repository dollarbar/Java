/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: November 3, 2022
 
 * Description: Assignment #9
 
 * This program demonstrates manipulating, sorting,
 
 * and removing duplicates from arrays. Also,
 
 * creating a new array with common elements.

 */


public class BerkezGlebAssignment8 {
	/******* MAIN CLASS **********/
	public static void main(String[] args) {
		// Initialize resorts array and snowfallAmount array
		String[] resorts = {"Vail", "Steamboat", "Wolf Creek", "Keystone", 
							"Breckenridge", "Telluride", "Purgatory"};
		double[] snowfallAmount = {189.2, 154.4, 430.2, 159.9, 184.6, 167.7, 260.2};
		
		// Print introductory display
		System.out.print("-----------------------------\nResort\t\t"
				+ "Yearly Snowfall\n-----------------------------\n");
		
		
		// CALL METHODS
		
		// Display table method
		display(resorts, snowfallAmount);
		
		// Total snowfall
		double totalSnowfall = computeTotalSnowfall(snowfallAmount);
		System.out.printf("\nTotal snowfall for all resorts is %5.2f", totalSnowfall);
		
		// Average snowfall method
		double averageSnowfall = computeAverageSnowfall(snowfallAmount);
		System.out.printf("\nAverage snowfall for all resorts is %5.2f", averageSnowfall);
		
		// Resort with most snowfall (name & amount)
		int indexOfMostSnowfall = findResortWithMostSnowfall(snowfallAmount);
		String resortNameOfMostSnowfall = resorts[indexOfMostSnowfall];
		double amountOfMostSnowfall = snowfallAmount[indexOfMostSnowfall];
		System.out.println("\n\nSki resort with most snow is " + resortNameOfMostSnowfall + " with "
				+ amountOfMostSnowfall + " inches per year\n");
		
		// All resorts with above average snowfall (name & amount)
		displayResortsWithAboveAverageSnowfall(resorts, snowfallAmount, averageSnowfall);
		
		// Playing with Dog Class
		Dog[] dogArray = new Dog[5];
		Dog dog1 = new Dog("Rover", "woof woof");
		Dog dog2 = new Dog("Max", "arf arf arf");
		Dog dog3 = new Dog("Tiny", "yap yap yap");
		Dog dog4 = new Dog("Trooper", "ruff ruff ruff");
		Dog dog5 = new Dog("Magoo", "bow wow bow wow");
		
		// place dog objects into dogArray
		dogArray[0] = dog1;
		dogArray[1] = dog2;
		dogArray[2] = dog3;
		dogArray[3] = dog4;
		dogArray[4] = dog5;
		
		System.out.println("\n\nMake the dogs bark!\n" +
							"------------------------------");
		
		// call makeDogsBark method
		makeDogsBark(dogArray);
		
	}//END MAIN
	
	
	/******** METHODS *******/
	// Display table method
	public static void display(String resorts[], double snowfallAmount[]) {
		String printDisplay = "";
		for (int i = 0; i < resorts.length; i++) {
			String string = resorts[i] + "\t\t" + snowfallAmount[i] + '\n';
			printDisplay = printDisplay + string;
		}
		System.out.println(printDisplay);
	}//end display method
	
	// Compute total snowfall method
	public static double computeTotalSnowfall(double[] snowfallAmount) {
		double totalSnowfall = 0;
		for (int i = 0; i < snowfallAmount.length; i++) {
			totalSnowfall += snowfallAmount[i];
		}
		return totalSnowfall;
	}//end computeTotalSnowfall method
	
	// Average snowfall method
	public static double computeAverageSnowfall(double[] snowfallAmount) {
		double averageSnowfall = computeTotalSnowfall(snowfallAmount) / snowfallAmount.length;
		return averageSnowfall;
	}// end averageSnowfall method
	
	// Resort with most snowfall (index of array)
	public static int findResortWithMostSnowfall(double[] snowfallAmount) {
		double mostSnowfall = 0;
		int index = 0;
		for (int i = 0; i < snowfallAmount.length ; i++) {
			if (snowfallAmount[i] > mostSnowfall ) {
				mostSnowfall = snowfallAmount[i];
				index = i;
			}//if statement
		}//for loop
		return index;
	}//end mostSnowfall method
	
	// Display all ski resorts with above snowfall method (name & amount)
	public static void displayResortsWithAboveAverageSnowfall(String[] resorts, double[] snowfallAmount, double averageSnowfall) {
		for (int i = 0; i < resorts.length; i++) {
			if (snowfallAmount[i] > averageSnowfall) {
				System.out.println(resorts[i] + " gets " + snowfallAmount[i] + " inches which is above average");
			}//if statement
		}//for loop
	}//aboveAverage method
	
	// makeDogsBard method
	public static void makeDogsBark(Dog[] dogArray) {
		String totalDogsBarkString = "";
		for (int i = 0; i < dogArray.length; i++) {
			
			String singleString = dogArray[i].getName() + " barks like this: " + dogArray[i].getBark() + "\n";
			totalDogsBarkString += singleString;
		}//for loop
		System.out.println(totalDogsBarkString);
	}//makeDogsBark method
	
}// end Assignment8 class

class Dog {
	
	private String name;
	private String bark; 
	
	public Dog(String name, String bark) {
		this.name = name; 
		this.bark = bark; 
	}

	public String getName() { 
		return name; 
	} 
	public void setName(String name) {
		this.name = name;
	}

	public String getBark() {
	    return bark;
	}
	
	public void setBark(String bark) {
		this.bark = bark;
	}
} // end Dog Class
