/*
  Q3: Write a Java program that demonstrates the Serialization and Deserialization process. The program should:
	- Define a Person class with two fields: name (String) and age (int).
	- Serialize an object of the Person class to a file (person.ser).
	- Deserialize the object from the file (person.ser) and print its data (name and age) to the console.
 */

import java.io.*;

// Define Person class which implements Serializable
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getters for printing
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Person p = new Person("Alice", 30);
        String filename = "person.ser";

        // Serialization: write the object to a file
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(p);
            System.out.println("Person object serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialization: read the object back from file
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Deserialized Person:");
            System.out.println("Name: " + deserializedPerson.getName());
            System.out.println("Age: " + deserializedPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
            System.out.println();
        }
    }
}
