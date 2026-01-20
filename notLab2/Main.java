package notLab2;
import java.util.*;

class Counter {

    static int count = 0;   // static variable to count objects

    Counter() {
        count++;          // increases each time an object is created
    }
}

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of objects: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            new Counter();    // creating objects
        }

        System.out.println("No of objects = " + Counter.count);
    }
}
