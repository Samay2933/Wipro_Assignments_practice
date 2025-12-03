import java.util.*;
import java.io.*;
public class Reader {
    /*
   
     BufferReader = FileReader : best for reading text files line by line   
     FileInputStream = Best for binary files(example, images, audio files)
     RandomAcessFile : Best for read/write specific portions of a large file 
     */

     public static void main(String[] args) {
        String filePath = "D:\\work\\VS code projects\\Data Structures\\File Handling\\Read\\text.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            System.out.println("The file exist");

            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);

        }

        }catch(FileNotFoundException e){
            System.out.println("Could not found file location");

        }catch(IOException e){
            System.out.println("Something went wrong");
            
        }
     }
}
