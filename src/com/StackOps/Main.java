package com.StackOps;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static StackUsingList stackUsingList = new StackUsingList();
	public static void main(String[] args) {
		System.out.println("StackOps");
		printInstructions();
		boolean quit = false;
		do {
			int response;
			System.out.println("Choose operation");
			response = scanner.nextInt();
			switch (response) {
				case 0: printInstructions();
						break;
				case 1: push();
						break;
				case 2: pop();
						break;
				case 3: printStack();
						break;
				case 4: quit = true;
						break;
			}
		} while (!quit);
	}

	public static void printInstructions() {
		System.out.println("0. Print instructions");
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. Print Stack");
		System.out.println("4. Exit");
	}

	public static void push() {
		scanner.nextLine();
		System.out.println("Enter item to push");
		stackUsingList.push(scanner.nextInt());
	}

	public static void pop() {
		scanner.nextLine();
		System.out.println("Item popped is: "+stackUsingList.pop());
	}

	public static void printStack() {
		stackUsingList.printStack();
	}
}
