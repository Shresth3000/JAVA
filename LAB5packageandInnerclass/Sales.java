package Marketing;

import General.Employee;

public class Sales extends Employee {
double b;
    public Sales(int id, String name, double basic) {
        super(id, name, basic);
b=basic;
    }

    public double tallowance() {
        return 0.05 * b;
    }
}



