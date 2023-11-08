/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: Sep 1, 2022
 
 * Description: Assignment #1
 
 * This program demonstrates that I understand basic program structure by
  
 * printing a couple paragraphs that tell the instructor what I’m passionate
        
 * about.  It also gives a little practice with arithmetic in Java.

 */

public class BerkezGlebAssignment1 {

	public static void main(String[] args) {
		
        // Part 1: Display Output
		// Print several sentences about yourself
		System.out.print("    My name is Gleb Berkez. During this recent week, I was\n"
				+ "hosted by my physics lab partner and had an amazing five hour\n"
				+ "conversation. He described me having a rare personality. I hate\n"
				+ "to think I am special, but my Myers-Briggs Type Indicator is INTP.\n"
				+ "This stands for introverted-intuitive-thinking-perceiving. This type\n"
				+ "comprises about 2 to 5 percent of the world population. Fun fact - \n"
				+ "INTPs inhabit many areas in Silicon Valley probably because INTPs\n"
				+ "are known to be natural logicians. So, in a way, I am special.\n\n"
				
				+ "    I like to learn about complex subjects and whatever spurs my\n"
				+ "curiosity. This is why my current pursuit in computer science is my\n"
				+ "sixth degree that I have majored in. I finished my Bachelor of Innovation\n"
				+ "degree in business finance at UCCS back in 2018. Since then, I have embarked\n"
				+ "on several adventures and more recently have submitted hundreds of\n"
				+ "application to start a career in finance. I changed my mind to pursue\n"
				+ "computer science. My adventures that I just mentioned included commercial\n"
				+ "fishing in Alaska, worked on a micro-startup in the blockchain industry,\n"
				+ "and worked for myself in an expedited shipping company. I like to try new things.\n\n"
				
				+ "    At this point in my life, I desire to learn a skill that is in demand,\n"
				+ "pays well, versatile between regions of the world, and versatile among\n"
				+ "industries. My two main focuses are to finish my computer science degree\n"
				+ "and get a job with a promising career outlook. These are my main goals,\n"
				+ "but I am still working on a couple things on the side. The benefits of being\n"
				+ "single I suppose. At this moment, I have an incling towards big data.\n"
				+ "I love mathematics and I have a comprehension in business, so it might\n"
				+ "be a good fit. I am very excited to be in this curriculum and am grateful\n"
				+ "for all the effort the instructors, professors, and assistants put\n"
				+ "towards the students in this life-changing chapter of life.\n\n\n "
				);
		
		// Part 2: Working with Expressions
		// Convert Fahrenheit to Celsius
		/* Program needs to be in table format with Fahrenheit at
		 * 0, 20, 40, 60, 80, 100 with corresponding Celsius next to
		 * relative figures.
		 */
		
		// Initialize Fahrenheit and Celsius variables
		int fahrenheit = 0;
		double celsius = (5.0 / 9) * (fahrenheit - 32);
		
		// Print out Fahrenheit and Celsius table
		System.out.println("Fahrenheit      Celsius");
		System.out.println("-----------------------------------------");
		
		System.out.println(fahrenheit + "                " + celsius);
		
		fahrenheit = fahrenheit + 20;
		//celsius = (5.0 / 9) * (fahrenheit - 32);
		System.out.println(fahrenheit + "               " + celsius);
		
		fahrenheit += 20;
		//celsius = (5.0 / 9) * (fahrenheit - 32);
		System.out.println(fahrenheit + "               " + celsius);
		
		fahrenheit = fahrenheit + 20;
		celsius = (5.0 / 9) * (fahrenheit - 32);
		System.out.println(fahrenheit + "               " + celsius);
		
		fahrenheit = fahrenheit + 20;
		celsius = (5.0 / 9) * (fahrenheit - 32);
		System.out.println(fahrenheit + "               " + celsius);
		
		fahrenheit = fahrenheit + 20;
		celsius = (5.0 / 9) * (fahrenheit - 32);
		System.out.println(fahrenheit + "              " + celsius);
				
	} // main
} // Assignment 1



