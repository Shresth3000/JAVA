import java.util.*;
public class grade {
    public static void main(String args[]){
        Scanner in =new Scanner(System.in);
        int a;
        System.out.println("Enter marks:");
        a=in.nextInt();
        if(a>=90){
            System.out.println("O Grade");
        }
        else if(a>=80){
            System.out.println("E Grade");
        }
        else if(a>=70){
            System.out.println("A Grade");
        }
       else if(a>=60){
            System.out.println("B Grade");
        }
       else if(a>=50){
            System.out.println("C Grade");
        }
        else if(a>=40){
             System.out.println("D Grade");
        }
        else{
             System.out.println("FAIL!");
        }
    }
    
}
