package com.MobilePhoneContactsCorrected;

import java.util.ArrayList;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;

	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();
	}

	public boolean addNewContact(Contact contact) {
		if (findContact(contact.getName()) >= 0) {
			System.out.println("Contact Already exists");
			return false;
		}

		myContacts.add(contact);
		return true;
	}

	private int findContact(Contact contact) {
		return this.myContacts.indexOf(contact); //returns <0 is it does not exist
	}

	private int findContact(String contactName) {
		for(int i=0; i<this.myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);
			if(contact.getName().equals(contactName))
				return i;  // returns index of contact whose name is queried
		}
		return -1;
	}

	public boolean updateContact(Contact oldContact, Contact newContact) {
		int foundPosition = findContact(oldContact);
		if(foundPosition<0) {
			System.out.println(oldContact.getName() + " was not found");
			return false;
		}
		this.myContacts.set(foundPosition,newContact);
		System.out.println(oldContact.getName()+" replaced with "+newContact.getName());
		return true;
	}

	public String queryContact(Contact contact) {
		if(findContact(contact)>=0)
			return contact.getName();
		return null;
	}

	public Contact queryContact(String name) {
		int position = findContact(name);
		if(position>=0) {
			return this.myContacts.get(position);
		}
		return null;
	}

	public boolean removeContact(Contact contact) {
		int foundPosition = findContact(contact);
		if(foundPosition<0) {
			System.out.println(contact.getName() + " was not found");
			return false;
		}
		this.myContacts.remove(foundPosition);
		System.out.println(contact.getName()+ " is deleted.");
		return true;
	}

	public void printContacts() {
		System.out.println("Printing Contacts...");
		for(int i=0; i<this.myContacts.size(); i++) {
			System.out.println(i+". "+
					this.myContacts.get(i).getName() + ": " +
					this.myContacts.get(i).getPhoneNumber());

		}
	}

}