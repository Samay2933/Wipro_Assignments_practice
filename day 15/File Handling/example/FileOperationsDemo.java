import java.io.*;

public class FileOperationsDemo {
    public static void main(String[] args) {
        try {
            // Create a file
            File originalFile = new File("example.txt");
            if (originalFile.createNewFile()) {
                System.out.println("File created: " + originalFile.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Write to the file using BufferedWriter
            FileWriter fw = new FileWriter(originalFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("This is some sample text.");
            bw.newLine();
            bw.write("More content to copy.");
            bw.close();
            System.out.println("Successfully wrote to the file.");

            // Rename (or move) the file - renameTo() can also change path
            File renamedFile = new File("renamed_example.txt");
            if (originalFile.renameTo(renamedFile)) {
                System.out.println("File renamed to: " + renamedFile.getName());
            } else {
                System.out.println("File rename failed.");
            }

            // Copy from renamed file to a new target file
            File copyFile = new File("copy_of_example.txt");
            FileReader fr = new FileReader(renamedFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fwCopy = new FileWriter(copyFile);
            BufferedWriter bwCopy = new BufferedWriter(fwCopy);

            String line;
            while ((line = br.readLine()) != null) {
                bwCopy.write(line);
                bwCopy.newLine();
            }

            br.close();
            bwCopy.close();

            System.out.println("File copied to: " + copyFile.getName());

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
