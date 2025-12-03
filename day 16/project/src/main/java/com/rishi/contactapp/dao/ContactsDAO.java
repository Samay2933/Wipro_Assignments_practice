package com.rishi.contactapp.dao;

import java.util.*;
import com.rishi.contactapp.model.Contact;


// Bean
public class ContactsDAO {
	private static List<Contact> contacts = new ArrayList<>();
	private static int size = 0;
	
	public static String addContacts(String name, String phone) {
		if(name == null || name.trim().isEmpty()) {
			return "Name is Empty. Contact not Added";
		}
		
		if(!phone.matches("\\d+")) {
			return "Invalid Phone Number. Contact not Updated";
		}

		size++;
		Contact c = new Contact(size, name, phone);
		contacts.add(c);
		return "Contact Added Successfully.";
	}
	
	
	public static List<Contact> getAllContactDetails(){
		return contacts;
	}
	
	public static String updateContacts(String str_id, String name, String phone) {
		int id = -1;
		try {
			id = Integer.parseInt(str_id);
		}catch(NumberFormatException e) {
			return "Invalid ID Number. Contact not Updated";
		}
		if(id < 0) {
			return "Id cant be 0 or negative.Contact not updated.";
		}
		
		if(name == null || name.trim().isEmpty()) {
			return "Name is Empty. Contact not Updated";
		}
		
		if(!phone.matches("\\d+")) {
			return "Invalid Phone Number. Contact not Updated";
		}
	
		for(Contact c : contacts) {
			if(c.getId() == id) {
				c.setName(name);
				c.setPhone(phone);
				return "Contact updated Successfully.";
			}
		}
		return "Id does not exist.";
	}
	
	public static String deleteContacts(String str_id) {
		int id = -1;
		try {
			id = Integer.parseInt(str_id);
		}catch(NumberFormatException e) {
			return "Invalid ID Number. Contact not deleted";
		}
		if(id < 0) {
			return "Id cant be 0 or negative.Contact not deleted.";
		}
		
		for(int i = 0; i <= contacts.size()-1; i++) {
			if(contacts.get(i).getId() == id) {
				contacts.remove(i);
				return "Contact deleted Successfully.";
			}
		}
		return "Id does not exist.";
		
	}
}
