import java.util.Scanner;

class Exprg1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[4];  

        System.out.println("Enter the numbers:");
        try {
            for (int i = 0; i <= 4; i++) { 
                arr[i] = sc.nextInt();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception in thread \"main\" " + e);
        }
    }
}
