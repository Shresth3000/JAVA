import java.util.*;
import java.io.*;
public class ReadWrite {
public static void main(String args[]){
        try{
          FileOutputStream fout=new
FileOutputStream("text.txt");
          String s="Welcome to javaTpoint.";
          byte b[]=s.getBytes();
          fout.write(b);
          fout.close();
          System.out.println("Wrote into file");
          FileInputStream fin=new FileInputStream("StudText.txt");
          int i=0;
          while((i=fin.read())!=-1){
              System.out.print((char)i);
          }
          fin.close();
         }
catch(Exception e){
System.out.println(e);}
   }
}