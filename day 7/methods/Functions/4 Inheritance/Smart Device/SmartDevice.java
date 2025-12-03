//Interface 


/*
 1. Create a SmartDevice class that can both Camera and Phone features. 
 Implement two interfaces Camera (with clickPhoto()) and Phone (with makeCall()) and 
 demonstrate a class Smartphone that combines both behaviors.
 */
import java.util.*;

interface Camera {
    void takePhoto();
}

interface Phone {
    default void makeCall(){
        System.out.println("Default Call");
    };
}

class SmartPhone implements Camera, Phone {
    public void takePhoto() {
        System.out.println("Smartphone takes Photo.");
    }

    public void makeCall() { //overwrites makeCall() in phone 
        System.out.println("Smartphone makes a Call.");
    }
}

public class SmartDevice{
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.takePhoto();
        sp.makeCall();
    }
    
}

