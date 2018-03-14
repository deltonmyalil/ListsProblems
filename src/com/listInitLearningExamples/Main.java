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
		System.out.println("Do you know the index of the item to be replaced? (y/n)");
		String response = scanner.nextLine();
		int index;
		if(response.equals("y")) {
			System.out.print("Enter index of item to be replaced: ");
			index = scanner.nextInt();
			scanner.nextLine(); //To clear the buffer so that next input will not raise exceptions
		} else {
			System.out.println("At least enter the name of the item to be replaced: ");
			String oldItem = scanner.nextLine();
//			scanner.nextLine();
			index = listInit1.findItem(oldItem);
		}

		if(index>-1) {
			System.out.println("Enter the new Item: ");
			String newItem = scanner.nextLine();
			listInit1.replaceGroceryItem(index, newItem);
			System.out.println("Item replaced");
		} else {
			System.out.println("Item to be replaced was not found!");
			System.out.println("Could not replace item");
		}
	}

	public static void removeItem() {
		System.out.println("Do you know the index of the item to be removed? (y/n)");
		String response = scanner.nextLine();
		int index;
		if(response.equals("y")) {
			System.out.print("Enter index of the item to be removed: ");
			index = scanner.nextInt();
		} else {
			System.out.println("At least enter the name of the item to be removed: ");
			String unwantedItem = scanner.nextLine();
			index = listInit1.findItem(unwantedItem);
		}
		if(index>-1) {
			listInit1.removeGroceryItem(index);
			System.out.println("Item Removed");
		} else {
			System.out.println("Could not remove item. Item doesn't exist or invalid index");
		}

	}

	public static void searchItem() {
		System.out.println("Enter name of item to be searched: ");
		String searchKey = scanner.nextLine();
		int index = listInit1.findItem(searchKey);
		if(index>=0) {
			System.out.println("Item found at index " + index);
		} else {
			System.out.println("Item not found");
		}
	}
}
