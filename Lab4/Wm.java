interface Motor{
float capacity=8f;
void run();
void consume();
}
class Washingmachine implements Motor{
public void run(){ 
System.out.println("Running");
}
public void consume(){
System.out.println("Consuming");
}
}
class Wm{
public static void main(String args[]){
Washingmachine obj=new Washingmachine();
System.out.println("Capacity is "+obj.capacity);

}
}