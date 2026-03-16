import java.util.Scanner;

class CounterThread extends Thread {
    int lower, upper;

    CounterThread(String name, int lower, int upper) {
        super(name);
        this.lower = lower;
        this.upper = upper;
    }

    public void run() {
        System.out.println("Thread - " + getName());
        System.out.print("Counter - ");

        for (int i = lower; i <= upper; i++) {
            System.out.print(i + "\t");
            try {
                Thread.sleep(5);   
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class SyncExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter thread name: ");
        String name = sc.nextLine();

        System.out.print("Enter lower range: ");
        int lower = sc.nextInt();

        System.out.print("Enter upper range: ");
        int upper = sc.nextInt();

        CounterThread t = new CounterThread(name, lower, upper);
        t.start();
    }
}