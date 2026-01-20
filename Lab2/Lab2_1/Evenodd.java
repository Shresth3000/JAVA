public class Evenodd {
    public static void main(String[] args) {

        if (args.length != 10) {
            System.out.println("Please enter exactly 10 numbers.");
            return;
        }

        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(args[i]);

            if (num % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        System.out.println("No of even elements: " + evenCount);
        System.out.println("No of odd elements: " + oddCount);
    }
}
