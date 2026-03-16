import java.io.*;

class CopyFile {
    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("Usage: java CopyFile <source> <destination>");
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])) {

            int i;
            while ((i = fin.read()) != -1) {
                fout.write(i);
            }

            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
