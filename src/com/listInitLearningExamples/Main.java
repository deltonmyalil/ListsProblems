package com.listInitLearningExamples;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static ListInit1 listInit1 = new ListInit1();

	public static void main(String[] args) {
		boolean quit = false;
		int choice = 0;
		printInstructions();
		while(!quit) {
			System.out.println("Enter choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); //to clear the input buffer so that it doesn't interfere with next input

			switch(choice) {
				case 0: printInstructions();
						break;
				case 1: listInit1.printGroceryList();
						break;
				case 2: addItem();
						break;
				case 3: modifyItem();
						break;
				case 4: removeItem();
						break;
				case 5: searchItem();
						break;
				case 6: quit= true;
						break;
			}
		}
	}

	public static void printInstructions() {
		System.out.println("Choose one: ");
		System.out.println("0. Print instructions again");
		System.out.println("1. Print current List");
		System.out.println("2. Add item to List");
		System.out.println("3. Replace an Item");
		System.out.println("4. Delete an Item");
		System.out.println("5. Search for an item");
		System.out.println("6. Quit");
	}

	public static void addItem() {
		System.out.print("Enter item name to be added: ");
		String itemName = scanner.nextLine();
		listInit1.addGroceryItem(itemName);
	}

	public static void modifyItem() {
		System.out.print("Enter index of item to be replaced: ");
		int index = scanner.nextInt();
		scanner.nextLine(); //To clear the buffer so that next input will not raise exceptions
		System.out.println("Enter the new Item: ");
		String newItem = scanner.nextLine();
		listInit1.replaceGroceryItem(index,newItem);
	}

	public static void removeItem() {
		System.out.print("Enter index of the item to be removed: ");
		int index = scanner.nextInt();
		listInit1.removeGroceryItem(index);
	}

	public static void searchItem() {
		System.out.println("Enter name of item to be searched: ");
		String searchKey = scanner.nextLine();
		int index = listInit1.findItem(searchKey);
		if(index>=0) {
			System.out.println("Item found at index "+index);
		}
	}
}
