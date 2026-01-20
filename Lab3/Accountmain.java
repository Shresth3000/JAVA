import java.util.*;
class Account {
    int acc_no;
    double balance;
    Scanner in=new Scanner(System.in);
    void input() {
        System.out.print("Enter Account Number: ");
        acc_no = in.nextInt();
        System.out.print("Enter Balance: ");
        balance = in.nextDouble();
    }
    void disp() {
        System.out.println("Account Number: " + acc_no);
        System.out.println("Balance: " + balance);
    }
}
class Person extends Account {
    String name;
    long aadhar_no;
Scanner in=new Scanner(System.in);
    void inputPerson() {
        System.out.print("Enter Name: ");
        name = in.nextLine();
        System.out.print("Enter Aadhar Number: ");
        aadhar_no = in.nextLong();
        super.input();          
 }
    void disp() {
        System.out.println("Name: " + name);
        System.out.println("Aadhar No: " + aadhar_no);
        super.disp();                        
	}
}
public class Accountmain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Person[] p = new Person[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details of Person " + (i + 1));
            p[i] = new Person();
            p[i].inputPerson();
        }
        System.out.println("\nDisplaying details of three persons:\n");
        for (int i = 0; i < 3; i++) {
            p[i].disp();
        }
       }
}

