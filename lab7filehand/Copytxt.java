import java.io.*;

public class Copytxt {
    public static void main(String[] args) throws IOException {

        File inputFile = new File("C:\\Users\\KIIT\\Desktop\\oopj\\lab7filehand\\text.txt");
        File outputFile = new File("C:\\Users\\KIIT\\Desktop\\oopj\\lab7filehand\\text1.txt");

        FileReader in = new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile);

        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }

        in.close();
        out.close();

        System.out.println("Text copied successfully!");
    }
}