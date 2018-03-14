package com.MobilePhoneContactsApp;
import java.util.Scanner;
import java.util.ArrayList;

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

public class MobilePhone {
	private static Contacts contacts = new Contacts();
	private static ArrayList<Contacts> contactsArrayList = new ArrayList<Contacts>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean loop = true;
		printMenu();
		while(loop) {
			System.out.println("Input choice: ");
			int option = scanner.nextInt();
			switch(option) {
				case 0: printMenu();
						break;
				case 1: printContactList();
						break;
				case 2: addNewContact();
						break;
				case 3: editExistingContact();
						break;
				case 4: removeContact();
						break;
				case 5: contactLookup();
						break;
				case 6: loop = false;
						break;
			}
		}
	}

	public static void printMenu() {
		System.out.println("0. Print Menu Again");
		System.out.println("1. Print Contacts List");
		System.out.println("2. Add new Contact");
		System.out.println("3. Edit Existing contact");
		System.out.println("4. Remove Contact");
		System.out.println("5. Contact Lookup");
		System.out.println("6. Exit App");
	}

	public static void printContactList() {
		for(int i=0; i<contactsArrayList.size(); i++) {
			Contacts tempToPrint = contactsArrayList.get(i);
			System.out.println("Contact number."+i+" Name: "+tempToPrint.getName()+"; Number: "+tempToPrint.getNumber());
		}
	}

	public static void addNewContact() {
		System.out.print("Enter name: ");
		scanner.nextLine();
		String name = scanner.nextLine();
//		scanner.nextLine(); //not sure whether is needed
		System.out.println("Enter number");
		long number = scanner.nextLong();
		contacts.setName(name);
		contacts.setNumber(number);
		contactsArrayList.add(contacts);
	}

	public static void editExistingContact() {
		System.out.print("Enter name to edit: ");
		Contacts tempContact = new Contacts();
		int i;
		long oldNumber;
		String name = scanner.nextLine();
		scanner.nextLine();
		for(i=0; i<contactsArrayList.size(); i++) {
			tempContact = contactsArrayList.get(i);
			if(tempContact.getName().equals(name)) {
				contactsArrayList.remove(i);
				break;
			}
		}
		System.out.println("Do you want to re-enter the name? (y/n)");
		String response = scanner.nextLine();
		if(response.equals("y")) {
			System.out.println("Enter new name: ");
			tempContact.setName(scanner.nextLine());
		} else {
			tempContact.setName(name);
		}

		oldNumber = tempContact.getNumber();
		System.out.println("Do you want to re-enter new number? (y/n)");
		String response2 = scanner.nextLine();
		if(response2.equals("y")) {
			System.out.println("Enter new number: ");
			tempContact.setNumber(scanner.nextLong());
		} else {
			tempContact.setNumber(oldNumber);
		}
		scanner.nextLine();
		contactsArrayList.add(tempContact);
		System.out.println("Replaced old contact");
	}

	public static void contactLookup() {
		System.out.println("Enter the name to lookup: ");
		String lookupName = scanner.nextLine();
		Contacts nameLookupTemp = new Contacts();
		int i;
		for(i=0; i<contactsArrayList.size(); i++) {
			nameLookupTemp = contactsArrayList.get(i);
			if(nameLookupTemp.getName().equals(lookupName)) {
				break;
			}
		}
		System.out.println("Requested Number is "+ nameLookupTemp.getNumber());
	}

	public static void removeContact() {
		System.out.println("Enter name to remove: ");
		scanner.nextLine();
		String removeName = scanner.nextLine();
		Contacts removeTempContact = new Contacts();
		for(int i=0; i<contactsArrayList.size(); i++) {
			removeTempContact = contactsArrayList.get(i);
			if(removeTempContact.getName().equals(removeName)) {
				contactsArrayList.remove(i);
				break;
			}
		}
		System.out.println("Contact removed");
	}
}
