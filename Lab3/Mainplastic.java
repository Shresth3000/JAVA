
import java.util.*;

class Box2d {
    float length;
    float width;

    float cost2d() {
        return length * width * 40;
    }
}

class Box3d extends Box2d {
    float height;

    float cost3d() {
        return length * width * height * 60;
    }
}

public class Mainplastic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        Box2d sheet = new Box2d();
        System.out.print("Enter length and width of 2D sheet: ");
        sheet.length = in.nextFloat();
        sheet.width = in.nextFloat();

        System.out.println("Cost of 2D plastic sheet: Rs " + sheet.cost2d());


        Box3d box = new Box3d();
        System.out.print("Enter height of 3D box: ");
        box.height = in.nextFloat();


        box.length = sheet.length;
        box.width = sheet.width;

        System.out.println("Cost of 3D plastic box: Rs " + box.cost3d());
    }
}
