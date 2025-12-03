class Plane{
    void land(){
        System.out.println("Plane landed");
    }
}
class FighterPlane extends Plane{
    void land(){
        System.out.println("Fighter Plane landed");
    }
    void launchmissile(){
        System.out.println("Missile launched");
    }
}
public class TypeCastingDemo {
    public static void main(String[] args) {
        System.out.println("------------------");
        System.out.println("Object casting");
        FighterPlane p = new FighterPlane();
        //upcasting
        Plane ref = p;
        ref.land();
        //downcasting 
        FighterPlane p1 = (FighterPlane) ref;
        p1.launchmissile();
    }
} 