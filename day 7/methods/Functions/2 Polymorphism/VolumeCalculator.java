import java.util.*;

/*
 Write a class VolumeCalculator that calculates the volume of different 3D shapes. 
 The class should have the following methods:
Calculate the volume of a cube (side length).
Calculate the volume of a sphere (radius).
Calculate the volume of a cylinder (radius and height).
 */

 class Volume{

    public int Volume(int a){
        return a*a*a;
    }


    
 }
public class VolumeCalculator {
    public static void main(String[] args) {

        Volume vol = new Volume();

        System.out.println(vol.Volume(5));
        

    }

    
}


/*
 * 
 class VolumeCalculator {

    // Volume of a cube: side^3
    public double volume(double side) {
        return side * side * side;
    }

    // Volume of a sphere: (4/3) * π * r^3
    public double volume(double radius, boolean isSphere) {
        if (isSphere) {
            return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
        }
        return -1; // Error code if not a sphere
    }

    // Volume of a cylinder: π * r^2 * h
    public double volume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

public class PolyDemo {
    public static void main(String[] args) {
        VolumeCalculator vc = new VolumeCalculator();

        double cubeVol = vc.volume(3); // Cube with side 3
        double sphereVol = vc.volume(2, true); // Sphere with radius 2
        double cylVol = vc.volume(2, 5); // Cylinder with radius 2 and height 5

        System.out.println("Cube volume: " + cubeVol);
        System.out.println("Sphere volume: " + sphereVol);
        System.out.println("Cylinder volume: " + cylVol);
    }
}

 */