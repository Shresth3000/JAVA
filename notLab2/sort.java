import java.util.*;
class sort{
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);
        int n;
        System.out.print("Enter number of elements in the array: ");
        n=in.nextInt();
        int[] arr= new int[n];
        System.out.print("Enter 10 numbers: ");
         for(int i=0;i<n;i++){
           arr[i]=in.nextInt();
        }
      
        for(int i=0;i<n-1;i++){
           for (int j=0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
           }
        }
        for(int x:arr){
            System.out.print(x+" ");
        }
        
    }
}
