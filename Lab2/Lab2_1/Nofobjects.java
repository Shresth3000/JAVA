package Lab2;
import java.util.*;
public class Nofobjects
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of Objects to create: ");
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            Createobj obj=new Createobj();
        }
        System.out.println("Number of objects created: "+Createobj.objCount);
    }
}
class Createobj{
    static  int objCount=0;
    Createobj()
    {
        objCount++;
    }
}
