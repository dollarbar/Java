/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: November 3, 2022
 
 * Description: Assignment #9
 
 * This program sorts, removes duplicates,
 
 * and finds common elements between arrays.

 */

public class BerkezGlebAssignment9 {

	public static void main(String[] args) {
		// Create 3 arrays
		int[] numbers1 = {4,11,5,10,7,6,8,9};
		int[] numbers2 = {5,6,3,8,8,7,4,5};
		int[] numbers3 = {3,3,4,3,6,3};
		
		// Display Original Arrays
		System.out.println("********************************\n" + 
							"Original Arrays\n" + 
						   "********************************\n");
		
		display(numbers1, "numbers1");
		display(numbers2, "numbers2");
		display(numbers3, "numbers3");
		
		// Display Removed Duplicates and Sorted Arrays
		System.out.println("********************************\n" + 
				"Removed Duplicates and Sorted Arrays\n" + 
			               "********************************\n");
		display(removeDuplicates(sortArray(numbers1)), "numbers1 - No Duplicate Values & Sorted");
		display(removeDuplicates(sortArray(numbers2)), "numbers2 - No Duplicate Values & Sorted");
		display(removeDuplicates(sortArray(numbers3)), "numbers3 - No Duplicate Values & Sorted");
		
		// Display Common Elements Between 3 Arrays
		System.out.println("********************************\n" + 
				"Finding Common Elements\n" + 
			               "********************************\n");
		
		display(findCommonElements(numbers1, numbers2, numbers3), 
							 "Common Elements Between 3 Arrays");
		
	}// END MAIN
	
	// Display the values in an array whose name is provided in arrayName
	public static void display(int[] array, String arrayName) {
		
		System.out.println(arrayName + "\n----------------------------");
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
		}//for
		System.out.print("\n");
	}// end display method
	
	// Sort Array 
	public static int[] sortArray(int[] arrayWithDuplicates) {
	
		// Find Smallest Element and Place at [0]
		int smallest = arrayWithDuplicates[0];
		int smallestIndex = 0;
		
		for (int i = 1; i < arrayWithDuplicates.length; i++) {
			if (smallest > arrayWithDuplicates[i]) {
				smallest = arrayWithDuplicates[i];
				smallestIndex = i;
			}	
		}//for
		if (smallestIndex != 0) {
			arrayWithDuplicates[smallestIndex] = arrayWithDuplicates[0];
			arrayWithDuplicates[0] = smallest;
		}//if
		
		// Process the rest of the array
		for (int i = 0; i < arrayWithDuplicates.length-1; i++) {
			smallest = arrayWithDuplicates[i];
			smallestIndex = i;
			
			for (int j = i+1; j < arrayWithDuplicates.length; j++) {
				if (smallest > arrayWithDuplicates[j]) {
					smallest = arrayWithDuplicates[j];
					smallestIndex = j;
				}
			}// for j
			
			if (smallestIndex != i) {
				arrayWithDuplicates[smallestIndex] = arrayWithDuplicates[i];
				arrayWithDuplicates[i] = smallest;
			}
		}// for
		return arrayWithDuplicates;
	}//method sort method
	
	// Remove Duplicates from Sorted Method
	public static int[] removeDuplicates(int[] sortedArray) {
		
		int distinctValue = 1;
		
		// for and if block find the number of distinct values
		for (int i = 1; i < sortedArray.length; i++) {
			if (sortedArray[i-1] != sortedArray[i]) {
				distinctValue += 1;
			}
		}
		// end block distinct values
		
		int[] arrayWithoutDuplicates = new int[distinctValue];
		
		// fill newArray with distinct values with if and for blocks
		for (int i = 1, j = 0; i < sortedArray.length; i++) {
			
			if (sortedArray[i-1] != sortedArray[i]) {
				arrayWithoutDuplicates[j] = sortedArray[i-1];
				j += 1;
			}
		}
		arrayWithoutDuplicates[arrayWithoutDuplicates.length-1] = sortedArray[sortedArray.length-1];
		
		return arrayWithoutDuplicates;
		
	}//end remove duplicates method
	
	// Find Common Elements Between 3 Arrays
	public static int[] findCommonElements(int array1[], int array2[], int array3[]) {
		
		// find number of distinct values to give new array
		int distinctValues = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					for (int k = 0; k < array3.length; k++) {
						if (array3[k] == array2[j]) {
							distinctValues += 1; 
						}//if
					}//for	
				}//if	
			}//for2
		}//for1
		
		// Create arrayWithCommonElements and add the common elements
		int[] arrayWithCommonElements = new int[distinctValues];
		int index = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					for (int k = 0; k < array3.length; k++) {
						if (array3[k] == array2[j]) {
							arrayWithCommonElements[index] = array1[i];
							index += 1;
						}//if
					}//for	
				}//if	
			}//for2
		}//for1
		
		return arrayWithCommonElements;
	}//end common elements method

}//CLASS
