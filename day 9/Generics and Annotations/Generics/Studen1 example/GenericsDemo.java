package Day6;
class Box<T> {
    T value;
    Box(T value) {
        this.value = value;
    }
    void show() {
        System.out.println("Value: " + value);
    }
}
public class GenericsDemo {
     public static void main(String[] args) {
        Box<String> box1 = new Box<>("Hello Generics");
        box1.show();
        Box<Double> box2 = new Box<>(12.5);
        box2.show();
        Box<Integer> box3 = new Box<>(12);
        box3.show();
    }
}

