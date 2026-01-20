package Lab3;
import java.util.*;

class Apple{
void show(){
    System.out.println("Apple");
}
}
class Banana extends Apple{
    void show(){
        System.out.println("Banana");
    }
}
class Cherry extends Apple{
    void show(){
        System.out.println("Cherry");
    }
}
public class Fruits {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        Apple A;
        A=new Apple();
        A.show();
        A=new Banana();
        A.show();
        A=new Cherry();
        A.show();
    }
}
