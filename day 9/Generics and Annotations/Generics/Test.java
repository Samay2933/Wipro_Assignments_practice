
import java.util.ArrayList;
import java.util.*;

// // Without Generics
// ArrayList list = new ArrayList();
// list.add("Hello");
// list.add(123); // No error, but can cause problems later

// // With Generics
// ArrayList<String> names = new ArrayList<>();
// names.add("Alice");
// // names.add(123); // ERROR at compile time!



/*
 Q1> Create a class Box that can store a single item. You want to store items in the box and retrieve them later.
Test it with different types like Integer and String. Without Generics and With Generics.
 */

//Custom Generic CLass Example 
class Box<T> {        // T is a TYPE placeholder ("type parameter")
    T value;
    void set(T value) { 
        this.value = value;
     }
     T get() {
        return value;
    }
}

public class Test {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(10);
        System.out.println(intBox.get()); // Prints: 10

        Box<String> strBox = new Box<>();
        strBox.set("Hello");
        System.out.println(strBox.get()); // Prints: Hello
    }
}

