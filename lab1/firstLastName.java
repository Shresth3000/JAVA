import java.util.*;
class firstLastName{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String First=in.nextLine();
        System.out.print("Enter last name: ");
        String last=in.nextLine();
        System.out.println(last+" "+First);
    }
}