class pen{
    String color;
    String type;
    public void write(){
        System.out.println("Writing");
    }
}
public class first{
    public static void main(String args[]){
        pen PEN1=new pen();
        PEN1.color="Blue";  
        PEN1.type="Gel";  
        PEN1.write();
        System.out.println(PEN1.color);
    }
}