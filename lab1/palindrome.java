import java.util.*;
public class palindrome {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int num1,num2;
        System.out.println("Enter a number: ");
        num1=in.nextInt();
        num2=num1;
        int sum=0,r=0;
        while(num2>0){
            r=num2%10;
            sum=10*sum+r;
            num2/=10;
        }
        if(num1==sum){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }
    }
}
