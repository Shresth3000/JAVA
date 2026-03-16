
import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {



        FileInputStream in = new FileInputStream("C:\\Users\\KIIT\\Desktop\\oopj\\lab7filehand\\pic1.jpeg");
        FileOutputStream out = new FileOutputStream("C:\\Users\\KIIT\\Desktop\\oopj\\lab7filehand\\pic3.jpeg");

        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }

        in.close();
        out.close();

        System.out.println("Image copied successfully!");
    }
}