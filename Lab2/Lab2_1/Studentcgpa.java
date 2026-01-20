import java.util.*;
class Studentdata{
int roll;
String name;
float cgpa;
}
public class Studentcgpa{
public static void main(String args[]){
Scanner in=new Scanner(System.in);
System.out.print("Enter number of students: ");
int n=in.nextInt();
Studentdata[] stud;
stud=new Studentdata[n];
for(int i=0;i<n;i++){
stud[i] = new Studentdata();
System.out.print("Enter Roll of student "+(i+1)+" : ");
stud[i].roll=in.nextInt();
System.out.print("Enter Name of student "+(i+1)+" : ");
in.nextLine();
stud[i].name=in.nextLine();
System.out.print("Enter CGPA of student "+(i+1)+" : ");
stud[i].cgpa=in.nextFloat();
}
for(int i=0;i<n;i++){
System.out.println("Roll No.: "+stud[i].roll);

System.out.println("Name : "+stud[i].name);

System.out.println("CGPA : "+stud[i].cgpa);
}
float minCgpa=10;
int index=0;
for(int i=0;i<n;i++){
if(stud[i].cgpa<minCgpa){ minCgpa=stud[i].cgpa;
index=i;
}
}
System.out.println("Min Cgpa STudent is: "+stud[index].name);

}
}
