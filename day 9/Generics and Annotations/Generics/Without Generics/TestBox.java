// A simple Box class WITHOUT generics
class Box {
    private Object item;  // 'Object' can hold any data type (int, String, etc.)

    // Method to store an item in the box
    void set(Object item) {
        this.item = item;
    }

    // Method to get the stored item
    Object get() {
        return item;
    }
}

// Test class
public class TestBox {
    public static void main(String[] args) {

        // Create a box to store an Integer
        Box intBox = new Box();
        intBox.set(100);  // storing an Integer object
        System.out.println("Integer Box: " + intBox.get());

        // Create a box to store a String
        Box strBox = new Box();
        strBox.set("Hello Box");  // storing a String object
        System.out.println("String Box: " + strBox.get());

        // Create a box to store a Double
        Box dblBox = new Box();
        dblBox.set(55.5);  // storing a Double object
        System.out.println("Double Box: " + dblBox.get());

        // Retrieving with casting (needed if you want to use the value specifically)
        int num = (int) intBox.get();  // Type casting back to Integer
        System.out.println("Retrieved Integer (after casting): " + num);
    }
}