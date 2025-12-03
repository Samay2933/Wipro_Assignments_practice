import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.util.*;

public class Writeafile {
    /*
     FileWriter = good for small or medium sized text files 
     BufferWriter = better performance for large amounts of text 
     PrintWriter = Best for structured data, like reports or logs 
     FileOutputStream = Best for binary files(example, images, audio files)
     */

     

    public static void main(String[] args) {
        String str1 = "I like Samosa\n";
        String str2 = "for the long text format \n\n";

        try {
            FileWriter writer = new FileWriter("test.txt"); //can give file location 
            writer.write(str1);
            writer.write(str2); // If you want to write both strings
            writer.close();
            System.out.println("File has been written");
        } catch (FileNotFoundException e) {
            System.out.println("Could not write file location");
        } catch (Exception e) {
            System.out.println("Could not write file");
        }
    }

}



