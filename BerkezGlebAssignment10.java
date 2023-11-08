/*
 * Name: Gleb Berkez
 
 * Class: CS1150 Section 6
 
 * Due: November 10, 2022
 
 * Description: Assignment #10
 
 * Objective of this program is to work with classes.
 
 * 1 class is a single object while the 2nd is
 
 * an array of objects. Set, get, and setup methods
 
 * in these classes.

 */

public class BerkezGlebAssignment10 {

	public static void main(String[] args) {
		
	/************************ USE TREE CLASS ************************/ 
	// Create tree objects
	Tree tree1 = new Tree("Giant Sequoia", 275);
	Tree tree2 = new Tree("Fremont Cottonwood", 68);
	Tree tree3 = new Tree("Sitka Spruce", 330);
	Tree tree4 = new Tree("Coast Douglas Fir", 297);
	Tree tree5 = new Tree("Costal Redwood", 379);
	Tree tree6 = new Tree("Southern Magnolia", 87);
	Tree tree7 = new Tree("White Oak", 144);
	
	//Hard code tree objects into Tree[] list
	Tree[] treeList = new Tree[7];
	treeList[0] = tree1;
	treeList[1] = tree2;
	treeList[2] = tree3;
	treeList[3] = tree4;
	treeList[4] = tree5;
	treeList[5] = tree6;
	treeList[6] = tree7;
	
	//Display
	String bannerTitle1 = "Trees in Array";
	String treesArrayDisplay = "******************************\n\t" + bannerTitle1 + 
					  "\n******************************\n\n" + 
					  "----------------------------------" + 
					  "\nTree\t\t\tHeight\n" + "----------------------------------\n";
	System.out.println(treesArrayDisplay);
	
	
	// for statement to iterate through array. Two terminal variables to solve # of spaces issue
	for (int i = 0, j = 1; i < treeList.length || j < treeList.length-1; i += 2, j += 2) {
		
		// if-else statement to avoid out of bounds error.
		if (j < treeList.length) {
			System.out.println(treeList[i].getTreeType() + "\t\t" + treeList[i].getTreeHeight());
			System.out.println(treeList[j].getTreeType() + "\t" + treeList[j].getTreeHeight());
			}
		else {
			System.out.println(treeList[i].getTreeType() + "\t\t" + treeList[i].getTreeHeight());
		}
	}//end for
	
	// for loop to find tallest tree in array of trees
	int tallestTreeHeight = 0;
	int index = 0;
	for (int i = 0; i < treeList.length; i++) {
		if (treeList[i].getTreeHeight() > tallestTreeHeight) {
			tallestTreeHeight = treeList[i].getTreeHeight();
			index = i;
		}
	}//end for
	
	//Display tallest tree name and height
	String displayTallestTreeInArray = "\n-------------------------------\n" + 
									   "Tallest tree in array of trees\n" + 
									   "-------------------------------\n";
	String resultsTallestTreeInArray = "Tree:   " + treeList[index].getTreeType() + "\n" +
									   "Height: " + treeList[index].getTreeHeight() + " feet";
	System.out.println(displayTallestTreeInArray + resultsTallestTreeInArray);
	//End Display for Objects in Array
	
	/****************** USE FOREST CLASS ******************/ 
	//Display banner
	String bannerTitle2 = "Trees in Forest Object";
	String treesArrayDisplay2 = "\n\n******************************\n" + bannerTitle2 + 
					  "\n******************************\n\n" + 
					  "----------------------------------" + 
					  "\nTree\t\t\tHeight\n" + "----------------------------------\n";
	System.out.println(treesArrayDisplay2);
	//End Display
	
	//Create new Forest Object
	Forest Redwood_National_Forest = new Forest("Redwood National Forest", 200);

	//Add the 7 trees to the Forest
	Redwood_National_Forest.addTree(tree1);
	Redwood_National_Forest.addTree(tree2);
	Redwood_National_Forest.addTree(tree3);
	Redwood_National_Forest.addTree(tree4);
	Redwood_National_Forest.addTree(tree5);
	Redwood_National_Forest.addTree(tree6);
	Redwood_National_Forest.addTree(tree7);
	
	//Display the current Forest
	Redwood_National_Forest.displayTrees();
	
	//Tallest Tree in Forest Display and Result
	String forestName = "Forest: " + Redwood_National_Forest.getForestName() + "\n";
	String displayTallestTreeInForest = "\n-------------------------------\n" + 
										"Tallest tree in Forest\n" + 
										"-------------------------------\n";
	String resultsTallestTreeInForest = "Tree:   " + Redwood_National_Forest.findTallestTree().getTreeType() + "\n" +
			   						    "Height: " + Redwood_National_Forest.findTallestTree().getTreeHeight() + " feet";
	System.out.println(displayTallestTreeInArray + forestName +  resultsTallestTreeInArray);
	
	}//main
	
	

}//Research Class

// TREE CLASS
class Tree{
	//Data Fields
	private String treeType;
	private int treeHeight;
	
	//Constructor
	public Tree(String type, int height) {
		treeType = type;
		treeHeight = height;
	}
	
	//Getter
	public String getTreeType() {
		return treeType;
	}
	public int getTreeHeight() {
		return treeHeight;
	}
}//End Tree Class

class Forest {
	//Private Data Fields
	private String forestName;
	private Tree trees[];
	private int numTrees;
	
	//Constructor
	public Forest(String name, int maxNumTrees) {
		forestName = name;
		trees = new Tree[maxNumTrees];
		numTrees = 0;
	}	
	
	//Getter
	public String getForestName() {
		return forestName;
	}
	
	//Setter
	public void addTree(Tree treeToAdd) {
		if (numTrees < trees.length) {
			trees[numTrees] = treeToAdd;
			numTrees += 1;
		}//if
	}//end addTree
	
	//Find tallest tree method
	public Tree findTallestTree() {
		int tallestTree = 0;
		int index = 0;
		for (int i = 0; i < numTrees; i++) {
			if (tallestTree < trees[i].getTreeHeight()) {
				tallestTree = trees[i].getTreeHeight();
				index = i;
			}//if
		}//for
		return trees[index];
	}//end findTallestTree
	
	//Display trees method
	public void displayTrees() {
		String allTrees = "";
		for (int i = 0, j = 1; i < numTrees || j < numTrees-1; i += 2, j += 2) {
			
			// if-else statement to avoid out of bounds error.
			if (j < numTrees) {
				System.out.println(trees[i].getTreeType() + "\t\t" + trees[i].getTreeHeight());
				System.out.println(trees[j].getTreeType() + "\t" + trees[j].getTreeHeight());
				}
			else {
				System.out.println(trees[i].getTreeType() + "\t\t" + trees[i].getTreeHeight());
			}
		}//end for
		System.out.println(allTrees);
	}//end displayTrees
	
	
}//End Forest Class
