import java.util.*;
import java.io.*;

class CopyFile {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Enter Source: ");
            String source = in.nextLine();

            System.out.print("Enter Destination: ");
            String destination = in.nextLine();

            FileReader fr = new FileReader(source);
            FileWriter fw = new FileWriter(destination);

            int c;

            while ((c = fr.read()) != -1) {
                fw.write(c);
            }

            fr.close();
            fw.close();

            System.out.println("File Copied Successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        in.close();
    }
}