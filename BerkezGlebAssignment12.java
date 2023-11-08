/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: December 1, 2022
 
 * Description: Assignment #12
 
 * Objective of the program is to 
 
 * use inheritance, polymorphism, and
 
 * encapsulation between an Animal superclass
 
 * and types of animal subclasses and store
 
 * these objects in a single array.
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BerkezGlebAssignment12 {

	public static void main(String[] args) throws IOException{
		
		//setup scanner to read from file (Animals.txt)
		File animalsText = new File("Animals.txt");
		Scanner animalScanner = new Scanner(animalsText);
		
		
		//read first integer to determine number of animals for array
		int numberOfAnimals = animalScanner.nextInt();
		
		//create array with the specific numberOfAnimals
		Animal[] animals = new Animal[numberOfAnimals];
		
		//create loop to read words from text file and create animal objects
		//each animal has to use its type class created
		for (int i = 0; i < numberOfAnimals; i++){
			String type = animalScanner.next().trim();
			String name = animalScanner.next().trim();
			double weight = animalScanner.nextDouble();
			String food = animalScanner.next().trim();
			String location = animalScanner.next().trim() + " " + animalScanner.next().trim();
			if(type.equals("Bear")){
				animals[i] = new Bear(name, weight, food, location);
			}//if type equals Bear
			if(type.equals("Elephant")) {
				animals[i] = new Elephant(name, weight, food, location);
			}
			if(type.equals("Hippo")) {
				animals[i] = new Hippo(name, weight, food, location);
			}
			if(type.equals("Penguin")) {
				animals[i] = new Penguin(name, weight, food, location);
			}
		}//end for loop
		
		//Create loop to display the different animals in animals array
		for(int i = 0; i < numberOfAnimals; i++) {
			String type = "";
			if(animals[i] instanceof Bear) {
				type = "Bear";
			}
			else if(animals[i] instanceof Elephant) {
				type = "Elephant";
			}
			else if(animals[i] instanceof Hippo) {
				type = "Hippo";
			}
			else{
				type = "Penguin";
			}
			System.out.println("Animal[" + i + "] is a " + type);
			System.out.println(type + " " + animals[i].toString());
			animals[i].eat();
			animals[i].sleep();
			animals[i].swim();
			
			//Spaces
			System.out.println("\n");
		}//end for loop for display
	}//end main
}//End BerkezAssignment Class

//Superclass Animal
class Animal{
	//private instance variables
	private String name;
	private double weight;
	private String food;
	private String location;
	
	//constructor
	public Animal() {};
	public Animal(String name, double weight, String food, String location) {
		this.name = name;
		this.weight = weight;
		this.food = food;
		this.location = location;
	}
	
	//getters
	public String getName() {
		return name;
	}
	public double getWeight() {
		return weight;
	}
	public String getFood() {
		return food;
	}
	public String getLocation() {
		return location;
	}
	
	//toString
	public String toString() {
		return "Name: " + getName() + " - Weighs: " 
			   + getWeight() + "lbs - Location: " + getLocation();
	}
	
	//animal class methods
	public void eat() {
		System.out.println("Animal is eating");
	}
	public void sleep() {
		System.out.println("Animal is sleeping - do not disturb");
	}
	public void swim() {
		System.out.println("Animal is swimming");
	}
}//end Superclass Animal

//Animal Subclass Bear
class Bear extends Animal{
	//Override any methods needed from Animal class
	public Bear() {}
	public Bear(String name, double weight, String food, String location) {
		super(name, weight, food, location);
	}
	
	//Bear override methods
	@Override
	public void eat() {
		System.out.println("Bear is eating " + getFood());
	}
	@Override
	public void sleep() {
		System.out.println("Bear is sleeping");
	}
	@Override
	public void swim() {
		System.out.println("Bear is swimming");
	}
}//end Subclass Bear

//Animal Subclass Elephant
class Elephant extends Animal{
	//Elephant constructor
	public Elephant(String name, double weight, String food, String location) {
		super(name, weight, food, location);
	}
	//no overrides in Elephant class
}//end Subclass Elephant

//Subclass Hippo
class Hippo extends Animal{
	//Hippo constructor
	public Hippo(String name, double weight, String food, String location) {
		super(name, weight, food, location);
	}
	//override proper methods
	@Override
	public void sleep() {
		System.out.println("Hippo is sleeping");
	}
}//end Subclass Hippo

//Subclass Penguin
class Penguin extends Animal{
	//Penguin constructor
	public Penguin(String name, double weight, String food, String location) {
		super(name, weight, food, location);
	}
	//override proper methods
	@Override
	public void eat() {
		System.out.println("Penguin is eating " + getFood());
	}
	@Override
	public void swim() {
		System.out.println("Penguin is swimming");
	}
}//end Subclass Penguin



