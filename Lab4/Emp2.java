import java.util.*;

interface Employee {
    void getDetails(String empId, String empName);
}

interface Manager1 extends Employee {
    void getDeptDetails(String deptId, String deptName);
}

class Head implements Manager1 {
    String empId, empName, deptId, deptName;

    public void getDetails(String empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public void getDeptDetails(String deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public void display() {
        System.out.println("Employee id - " + empId);
        System.out.println("Employee name - " + empName);
        System.out.println("Department id - " + deptId);
        System.out.println("Department name - " + deptName);
    }
}

public class Emp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Head h = new Head();

        System.out.print("Enter employee id - ");
        String empId = sc.nextLine();
        System.out.print("Enter employee name - ");
        String empName = sc.nextLine();
        System.out.print("Enter department id - ");
        String deptId = sc.nextLine();
        System.out.print("Enter department name - ");
        String deptName = sc.nextLine();

        h.getDetails(empId, empName);
        h.getDeptDetails(deptId, deptName);

        h.display();
    }
}