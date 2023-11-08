/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: November 17, 2022
 
 * Description: Assignment #11
 
 * Objective of the program is to use 
 
 * aggregation between classes (has-a relationships)
 
 * and see how manipulating variables from child
 
 * classes affects objects as a whole. There is also 
 
 * printing results onto a file.

 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class BerkezGlebAssignment11 {

	public static void main(String[] args) throws IOException {
		//create list of Car objects
		Car[] cars = new Car[5];
		Car[] carsWithoutGas = new Car[5];
		
		createCars(cars);
		printCars(cars);
		
		//Create simulation
		
		// counter j for carsWithoutGas array outside of loop
		int j = 0;
		boolean allCarsAreEmpty = false;
		
		while (!allCarsAreEmpty) {
			for (int i = 0; i < cars.length; i++) {
				if  (cars[i].getFuelLevel().equals("Has Gas")) {
					//Determine # gallons needed to go 25 miles (gallonsForIteration)
					double gallonsForIteration = 25/cars[i].getMpg();
					if (cars[i].fuelGauge.getGallons() >= gallonsForIteration) {
						//Decrement Fuel Gauge
						cars[i].fuelGauge.decrementGallons(gallonsForIteration);
						//Increment Odometer
						cars[i].odometer.incrementMiles(25);
					}//if
				
					else {
						//change fuel level to empty and add car to carsWithoutGas List
						carsWithoutGas[j] = cars[i];
						cars[i].setFuelLevel("Empty");
						j += 1;
						
					}//else	
				}//end if
			}//end for loop
		
		//Check if all cars are empty
		allCarsAreEmpty = checkFuelLevels(cars);
		
		}//end while loop
		
		
		//Cars ran out of gas in this order table
		System.out.println("\n\n\nCars ran out of gas in this order: \n" +
						   "---------------------------------------");
		for (int i = 0; i < carsWithoutGas.length; i++) {
			System.out.println("Ran out of gas: " + carsWithoutGas[i].getOwner());
		}
		
		//Print updated car objects
		printCars(cars);
		writeCarDetailsToFile(cars);
		
	}// MAIN

	public static void createCars(Car[] cars) {
		Car car1 = new Car("Shrek", "Toyota Tundra", 15, 20000, 6);
		Car car2 = new Car("Fiona", "Audi Q7", 21, 8270, 10);
		Car car3 = new Car("Donkey", "Jeep CJ5", 14, 11800, 5);
		Car car4 = new Car("Farquaad", "Smart Car", 42, 710, 4);
		Car car5 = new Car("Dragon", "Chevy Suburban", 12, 10800, 30);
		
		cars[0] = car1;
		cars[1] = car2;
		cars[2] = car3;
		cars[3] = car4;
		cars[4] = car5;
	}//end createCars
	
	public static void printCars(Car[] cars) {
		String banner = "\n------------------------------------------------------------\n" + 
						"Owner\t\tVehicle\t\tMPG\tGallons\t   Mileage\n" + 
						"------------------------------------------------------------";
		System.out.println(banner);
		
		//Iterate through cars variables for each car and print
		for (int i = 0; i < cars.length; i++) {
			if (i == 1) {
				System.out.printf("\n" + cars[i].getOwner() + "\t\t" + cars[i].getModel() + "\t\t" + 
								   cars[i].getMpg() + "\t" + "%2.2f" + 
								   "\t   " + cars[i].getOdometer().getMiles(), cars[i].getFuelGauge().getGallons());
			}
			else if (i == 3) {
				System.out.printf("\n" + cars[i].getOwner() + "\t" + cars[i].getModel() + "\t" + 
						   cars[i].getMpg() + "\t" + "%2.2f" + 
						   "\t   " + cars[i].getOdometer().getMiles(), cars[i].getFuelGauge().getGallons());
			}
			else {
				System.out.printf("\n" + cars[i].getOwner() + "\t\t" + cars[i].getModel() + 
								   "\t" + cars[i].getMpg() + "\t" + "%2.2f" + 
								   "\t   " + cars[i].getOdometer().getMiles(), cars[i].getFuelGauge().getGallons());
			}
				
		}//for
	}//end printCars method
	
	public static boolean checkFuelLevels(Car[] cars) {
		//iterate through all cars to see if all have necessary fuel levels
		boolean fuelLevel = true;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getFuelLevel().equals("Has Gas")) {
				fuelLevel = false;
				
			}//if
		}//for loop
		
		return fuelLevel;
	}
	
	public static void writeCarDetailsToFile (Car[] cars) throws IOException{
		// Setup the file reference variable to refer to the text file.
		
		File fileName = new File("Assignment11.txt");
		
		//variable resultsFile in the code.
		
		PrintWriter resultsFile = new PrintWriter(fileName);
		
		//Write the details for each car to the file
		resultsFile.println("Car Details");
		for(int i = 0; i < cars.length; i++) {
			resultsFile.println(cars[i].getOwner());
			resultsFile.println(cars[i].getModel());
			resultsFile.println(cars[i].getMpg());
			resultsFile.println(cars[i].getFuelGauge().getGallons());
			resultsFile.println();
		}
		resultsFile.close();
		
		// Show where the file is located on your hard drive
		System.out.println("\n\nFind the file here " + fileName.getAbsolutePath());
		System.out.println();
	}//writeCarDetailsToFile
	
}// Assignment Class




class Car {
	//Private Instance Variables
	String owner;
	String model;
	double mpg;
	String fuelLevel = "Has Gas";
	Odometer odometer;
	FuelGauge fuelGauge;
	
	//Constructor
	public Car(String owner, String model, double mpg, double mileage, double gallons) {
		this.owner = owner;
		this.model = model;
		this.mpg = mpg;
		odometer = new Odometer(mileage);
		fuelGauge = new FuelGauge(gallons);
	}
	
	//Public Variables
	//Getters
	public String getOwner() {
		return owner;
	}
	public String getModel() {
		return model;
	}
	public double getMpg() {
		return mpg;
	}
	public String getFuelLevel() {
		return fuelLevel;
	}
	public Odometer getOdometer() {
		return odometer;
	}
	public FuelGauge getFuelGauge() {
		return fuelGauge;
	}
	
	//Setters
	public void setFuelLevel(String string) {
		if (string.equals("Empty")) {
			fuelLevel = "Empty";
		}
		else {
			fuelLevel = "Has Gas";
		}
	}
}//END CAR CLASS

class FuelGauge {
	//Private Instance Variables
	double gallons;
	
	//Constructor
	public FuelGauge(double gallons) {
		this.gallons = gallons;
	}
	
	//Getters and Setters
	public double getGallons() {
		return gallons;
	}
	public void decrementGallons(double gallonsUsed) {
		if((gallons - gallonsUsed) > 0) {
			gallons -= gallonsUsed;
		}
		else {
			gallons = 0;
			
		}
	}
}//END FUELGAUGE CLASS

class Odometer {
	//Private Instance Variables
	double mileage;
	
	//Constructor
	public Odometer(double mileage) {
		this.mileage = mileage;
	}
	
	//Getter
	public double getMiles() {
		return mileage;
	}
	
	//Increment Miles Method
	public void incrementMiles(double milesTraveled) {
		mileage += milesTraveled;
	}
}//END ODOMETER CLASS

