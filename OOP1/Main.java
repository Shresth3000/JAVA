import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        //Shresth is an object of class Student
        Student Shresth=new Student(610,"Shresth Agrawal",99.5f);
        System.out.print(Shresth.rno +"\n"+Shresth.name+"\n"+Shresth.marks);
    }
}
//Class or template
class Student{
    int rno;
    String name;
    float marks;
    //Constructor of class Student not the default constructor
    Student(int a,String b,float c){
        this.rno=a;
        this.name=b;
        this.marks=c;
    }
}