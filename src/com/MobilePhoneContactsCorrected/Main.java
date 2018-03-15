package com.MobilePhoneContactsCorrected;

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("00000");

	public static void main(String[] args) {
		boolean quit = false;
		startphone();
		printActions();
		while (!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();

			switch (action) {
				case 0:
					System.out.println("Turning off...");
					quit = true;
					break;
				case 1:
					mobilePhone.printContacts();
					break;
				case 2:
					addNewContact();
					break;
				case 3:
					updateContact();
					break;
				case 4:
					removeContact();
					break;
				case 5:
					queryContact();
					break;
				case 6:
					printActions();
					break;
			}

		}
	}

	private static void addNewContact() {
		System.out.print("Enter new contact's name: ");
		String name = scanner.nextLine();
		System.out.print("Enter number: ");
		String phone = scanner.nextLine();
		Contact newContact = Contact.createRecord(name, phone);
		if (mobilePhone.addNewContact(newContact)) {
			System.out.println("New Contact Added: " + name + "; " + phone);
		} else {
			System.out.println("Cant add " + name + ", already on file.");
		}
	}

	private static void updateContact() {
		System.out.print("Enter existing contact name: ");
		String name = scanner.nextLine();
		Contact existingContactRecord = mobilePhone.queryContact(name);
		if(existingContactRecord==null) {
			System.out.println("Contact not found");
			return;
		}
		System.out.print("Enter new contact name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter new number: ");
		String newNumber = scanner.nextLine();
		Contact newContact = Contact.createRecord(newName,newNumber);
		if(mobilePhone.updateContact(existingContactRecord,newContact)) {
			System.out.println("Updated Record");
		} else {
			System.out.println("Error updating record");
		}
	}

	private static void removeContact() {
		System.out.print("Enter contact name to remove: ");
		String name = scanner.nextLine();
		Contact existingContactRecord = mobilePhone.queryContact(name);
		if (existingContactRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		if(mobilePhone.removeContact(existingContactRecord)) {
			System.out.println("Removed Contact");
		} else {
			System.out.println("Error removing contact");
		}
	}

	private static void queryContact() {
		System.out.print("Enter contact name to lookup: ");
		String name = scanner.nextLine();
		Contact existingContactRecord = mobilePhone.queryContact(name);
		if (existingContactRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		System.out.println("Name: "+existingContactRecord.getName()+"; Ph: "+existingContactRecord.getPhoneNumber());
	}

	private static void startphone() {
		System.out.println("Starting phone...");
	}

	private static void printActions() {
		System.out.println("0. Turn Off");
		System.out.println("1. Show Contacts");
		System.out.println("2. Add new contact");
		System.out.println("3. Update Existing Contact");
		System.out.println("4. Remove Contact");
		System.out.println("5. Query Contact");
		System.out.println("6. Print list again");
		System.out.println("Waiting for input...");
	}
}
