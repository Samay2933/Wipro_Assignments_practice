package com.rishi.contactapp.dao;

import com.rishi.contactapp.model.Contact;
import java.util.*;

public class ContactDAO {
	private static List<Contact> list = new ArrayList<>();
    private static int idCounter = 1;

    // Initial sample contacts for testing list page
    static {
        list.add(new Contact(idCounter++, "Alice", "9991110001"));
        list.add(new Contact(idCounter++, "Bob", "8882220002"));
    }

    public static List<Contact> getAll() {
        return list;
    }

    public static void add(Contact c) {
        c.setId(idCounter++);
        list.add(c);
    }

    public static Contact getById(int id) {
        for(Contact c : list) {
            if(c.getId() == id) return c;
        }
        return null;
    }

    public static void update(Contact c) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == c.getId()) {
                list.set(i, c);
                return;
            }
        }
    }

    public static void delete(int id) {
        list.removeIf(c -> c.getId() == id);
    }
}
