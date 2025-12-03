import java.io.*;

public class FileDemo {
    public static void main(String[] args) {
        try {
            // 1. Create a File
            File myFile = new File("example.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }

            // 2. Write to the file using FileWriter
            FileWriter writer = new FileWriter(myFile);
            writer.write("I like Java Programming.\nSecond line here.");
            writer.close();
            System.out.println("Successfully wrote to the file.");

            // 3. Read from the file using FileReader
            FileReader reader = new FileReader(myFile);
            System.out.println("exact file path: "+myFile.getAbsolutePath());
            
            int ch;
            System.out.println("Reading from file:");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            
            
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
