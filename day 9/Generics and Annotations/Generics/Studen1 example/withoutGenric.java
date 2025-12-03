package Day6;
class Box1{
    String value;
    
    Box1(String value){
        this.value=value;
    }
    void show() {
        System.out.println("Value: " + value);
    }  
}
class Box2{
    int value;
    Box2(int value){
        this.value=value;
    }
    void show() {
        System.out.println("Value: " + value);
    }
}
public class withoutGenric {
    public static void main(String[] args) {
        Box1 b = new Box1("ABC");
        b.show();
        Box2 b2 = new Box2(12);
        b2.show();
    }
}