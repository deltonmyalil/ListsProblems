package com.listInitLearningExamples;

import java.util.ArrayList;

public class ListInit1 {
	//creating a grocery list: list of Strings
	//Unlike creating an array ie
	//int[] myArray = new int[10];
	//this is a class, calling a constructor. Hence the (). Mention datatype in <>
	private ArrayList<String> groceryList = new ArrayList<String>();
//	private ArrayList<String> nextList = new ArrayList<String >(groceryList); //This copies groceryList into the new arrayList by passing it to the constructor
//	private String[] regularArray = new String[groceryList.size()]; //To initialize a regular array with the arraylists size
//	regularArray = groceryList.toArray(regularArray); //To convert into regular array //Wont work in this class

	public void addGroceryItem(String item) {
		groceryList.add(item);
	}

	public void printGroceryList() {
		System.out.println("You have "+groceryList.size()+" items in your list");
		for(int i=0; i<groceryList.size(); i++) {
			System.out.println("index "+i+": "+groceryList.get(i));
		}
	}

	public void replaceGroceryItem(int index, String newItem) {
		groceryList.set(index,newItem);
	}

	public void removeGroceryItem(int index) {
		String removedItem = groceryList.get(index);
		groceryList.remove(index);
		System.out.println("removed "+removedItem);
	}

	public int findItem(String searchKey) {
//		boolean exists = groceryList.contains(searchKey);
		int index = groceryList.indexOf(searchKey); //This returns the index if it is contained in AL, returns -1 otherwise
//		if(index>=0)
//			return groceryList.get(index);
//		else
//			return null;
		return index;
	}

	public ArrayList<String> getGroceryList() {
		return groceryList;
	}
}
