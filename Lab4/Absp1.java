import java.util.*;

abstract class Student {
    Scanner in = new Scanner(System.in);
    int roll_no;
    int reg_no;

    void getinput() {
        System.out.print("Enter Roll no. : ");
        roll_no = in.nextInt();
        System.out.print("Enter Reg no. : ");
        reg_no = in.nextInt();
    }

    abstract void course();
}

class Kiitian extends Student {
    void course() {
        System.out.println("Roll- " + roll_no);
        System.out.println("Reg No - " + reg_no);
        System.out.println("Course- Btech CSE ");
    }
}

class Absp1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Student stud;
        stud = new Kiitian();
        stud.getinput();
        stud.course();
    }
}
