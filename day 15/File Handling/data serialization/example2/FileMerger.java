/*
 Q2: Write a Java program that:

	- Reads the contents of two text files: file1.txt and file2.txt.
	- Merges the content of both files alternating line by line (one line from file1.txt, then one from file2.txt).
	- Writes the merged content to a new file called merged.txt.
	- If one file has more lines than the other, the remaining lines from the longer file should be appended after the alternating lines.
	- Prints "Merge completed successfully!" once done.
 */

import java.io.*;
import java.nio.file.*;

public class FileMerger {
    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String mergedFile = "merged.txt";

        try (
            BufferedReader reader1 = Files.newBufferedReader(Paths.get(file1));
            BufferedReader reader2 = Files.newBufferedReader(Paths.get(file2));
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(mergedFile));
        ) {
            String line1, line2;
            boolean file1HasLines = true, file2HasLines = true;

            while (true) {
                line1 = reader1.readLine();
                line2 = reader2.readLine();

                if (line1 == null) file1HasLines = false;
                if (line2 == null) file2HasLines = false;

                if (!file1HasLines && !file2HasLines) {
                    break;  // Both files ended
                }

                if (file1HasLines) {
                    writer.write(line1);
                    writer.newLine();
                }

                if (file2HasLines) {
                    writer.write(line2);
                    writer.newLine();
                }
            }

            System.out.println("Merge completed successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

}
