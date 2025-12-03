/*
Q1: Write a Java program that:
	- Create a text file essay.txt with multiple lines.
	- Open the text file and read the file line by line.
	- Counts the total number of words in the file.
	- Writes the following information to a new file called report.txt:
		Total number of lines: <number_of_lines>
		Total number of words: <number_of_words>
	- Closes both files properly
	- Prints "Report generated successfully!" after writing.
 */


import java.io.*;
import java.nio.file.*;

public class FileWordCount {

    public static void main(String[] args) {
        String inputFileName = "essay.txt";
        String outputFileName = "report.txt";

        // Step 1: Create essay.txt with multiple lines
        String[] sampleLines = {
            "This is the first line.",
            "Here is the second line of the essay.",
            "And finally the third line."
        };

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(inputFileName))) {
            for (String line : sampleLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing sample essay file: " + e.getMessage());
            return;
        }

        int lineCount = 0;
        int wordCount = 0;

        // Step 2 & 3: Read the file line by line and count words
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                // Split line into words using space and punctuation as separators
                String[] words = line.trim().split("\\s+");
                // Handle empty lines
                if (words.length == 1 && words[0].isEmpty()) {
                    continue;
                }
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("Error reading the essay file: " + e.getMessage());
            return;
        }

        // Step 4: Write results to report.txt
        try (BufferedWriter reportWriter = Files.newBufferedWriter(Paths.get(outputFileName))) {
            reportWriter.write("Total number of lines: " + lineCount);
            reportWriter.newLine();
            reportWriter.write("Total number of words: " + wordCount);
            reportWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error writing the report file: " + e.getMessage());
            return;
        }

        // Step 5: Print success message
        System.out.println("Report generated successfully!");
    }
}
