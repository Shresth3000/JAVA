import java.util.*;
import java.io.*;

class Student {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        try {

            System.out.print("Enter Roll No.: ");
            int roll = in.nextInt();
            System.out.print("Enter Name: ");
            String name = in.nextLine();

            System.out.print("Enter Subject: ");
            String sub = in.nextLine();

            System.out.print("Enter Marks: ");
            float marks = in.nextFloat();
            in.nextLine();   

            System.out.print("Enter File name: ");
            String fileName = in.nextLine();

            
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Roll No: " + roll);
            bw.newLine();
            bw.write("Name: " + name);
            bw.newLine();
            bw.write("Subject: " + sub);  
            bw.newLine();
            bw.write("Marks: " + marks);
            bw.newLine();
            
            bw.newLine();

            bw.close();

            System.out.println("\nStudent details written successfully!\n");

           
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("Content of the file:\n");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        in.close();
    }
}