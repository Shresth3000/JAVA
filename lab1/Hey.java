package lab1;

import java.util.*;

class Hey {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 Student detail(Roll no:,Name and CGPA): ");
        int rno = in.nextInt();
        String name = in.nextLine();
        float cgpa = in.nextFloat();
        Student shresth = new Student(rno, name, cgpa);
        System.out.println("Roll no: " + shresth.rno + "\nName :" + shresth.name + "\nCGPA: " + shresth.cgpa + "\nClass Strength: " + Student.classStrength);
    }
}

class Student {
    int rno;
    String name;
    float cgpa;
    static int classStrength = 0;

    Student() {
        this.rno = 0;
        this.name = null;
        this.cgpa = 0.0f;
        Student.classStrength += 1;
    }

    Student(int rno, String name, float cgpa) {
        this.rno = rno;
        this.name = name;
        this.cgpa = cgpa;
        Student.classStrength += 1;
    }
}