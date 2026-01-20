import java.util.*;
class Occourance{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n=in.nextInt();
        int[] arr=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        System.out.print("Enter "+n+" elements: ");
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
    for (int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
           System.out.println("Occurrence of " + e.getKey() + "=" + e.getValue());
        }
    }
}