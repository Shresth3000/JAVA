import java.util.*;
class NegativeNumberException extends Exception {
    public String toString(){
        return "NegativeNumberException Occured";
    }
}

class NegativeErr {

    static void ProcessInput(int n) throws NegativeNumberException {
        if (n < 0) {
            throw new NegativeNumberException();
        } else {
            System.out.println("Double value: " + (2 * n));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        try {
            ProcessInput(num);
        } catch (NegativeNumberException e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occurred: " + e);
        }
    }
}
