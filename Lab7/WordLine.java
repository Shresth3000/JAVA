import java.io.*;
import java.util.*;

public class WordLine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String filename = sc.nextLine();

        int charCount = 0;
        int lineCount = 0;
        int wordCount = 0;

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lineCount++;  

                charCount += line.length();  

                String words[] = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;  
                }
            }

            fileScanner.close();

            System.out.println("No. of characters = " + charCount);
            System.out.println("No. of lines = " + lineCount);
            System.out.println("No. of words = " + wordCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        sc.close();
    }
}