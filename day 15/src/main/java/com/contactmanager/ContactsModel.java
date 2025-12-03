package com.contactmanager;

public class ContactsModel {
	private String name;
	private String phone;
	
	public ContactsModel(String name, String phone){
		this.name = name;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
}
