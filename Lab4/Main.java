import java.util.Scanner;

interface Staff {
    double earnings(double basic);
    double deductions(double basic);
    double bonus(double basic);
}

class Manager implements Staff {
    public double earnings(double basic) {
        return basic + (0.8 * basic) + (0.15 * basic);
    }

    public double deductions(double basic) {
        return 0.12 * basic;
    }
 public double bonus(double basic) {
        return 0;
    }
   
}

class Substaff extends Manager {
    
    public double bonus(double basic) {
        return 0.5 * basic;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double basic = sc.nextDouble();
        Substaff s = new Substaff();
        System.out.println("Earnings - " + s.earnings(basic));
        System.out.println("Deduction - " + s.deductions(basic));
        System.out.println("Bonus - " + s.bonus(basic));
    }
}