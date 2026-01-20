import java.util.*;
class Rectangle{
Scanner in = new Scanner(System.in);
float length;
float breadth;
float perimeter=0;
float area=0;
void read(){
System.out.print("Enter length of rectangle : ");
this.length=in.nextFloat();
System.out.print("Enter breadth of rectangle : ");
this.breadth=in.nextFloat();
}
void calculate(){
this.perimeter=2*(length+breadth);
this.area=length*breadth;
}
void display(){
System.out.println("Area is: "+area+" Perimeter is: "+perimeter);
}
}
class Prg4{
public static void main(String args[]){
Scanner in = new Scanner(System.in);
Rectangle rect = new Rectangle();
rect.read();
rect.calculate();
rect.display();
}
} 