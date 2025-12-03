import java.util.*;

public class LearnArraysClass {
    public static void main(String[] args) {
        //sorting , small operatio , fill 

        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        // //binarySearch
        // int index = Arrays.binarySearch(numbers, 4);

        // System.out.println("The index of element 4 in the array: "+index);

        // //Sort 
        // Arrays.sort(numbers);

        // for(int i:numbers){
        //     System.out.print(i +" ");
        // }

        //fill
        Arrays.fill(numbers,12);

        for(int i:numbers){
            System.out.print(i +" ");
        }


    }
    
}
