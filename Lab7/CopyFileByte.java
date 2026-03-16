import java.io.*;
import java.util.Scanner;

class CopyFileByte {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter source file name: ");
            String source = sc.nextLine();

            System.out.print("Enter destination file name: ");
            String destination = sc.nextLine();

            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination);

            int b;

            while ((b = fis.read()) != -1) {
                fos.write(b);
                
            }

            fis.close();
            fos.close();

            System.out.println("File Copied Successfully (Byte Stream)");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}