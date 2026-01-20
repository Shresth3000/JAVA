import java.util.*;
class EvenOdd{
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);
        int[] arr= new int[10];
        System.out.print("Enter 10 numbers: ");
         for(int i=0;i<10;i++){
           arr[i]=in.nextInt();
        }
       int eve=0,odd=0;
        for(int i=0;i<10;i++){
            if(arr[i]%2==0) eve++;
            else odd++;
        }
        System.out.print("Even : "+eve+"\nOdd : "+odd);
    }
}
