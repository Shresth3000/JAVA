

import java.util.Scanner;

class Plate {
    float length;
    float width;

    Plate(float l, float w) {
        length = l;
        width = w;
        System.out.println("Plate Constructor Called");
    }
}

class Box extends Plate {
    float height;

    Box(float l, float w, float h) {
        super(l, w);
        height = h;
        System.out.println("Box Constructor Called");
    }
}

class Woodbox extends Box {
    float thickness;

    Woodbox(float l, float w, float h, float th) {
        super(l, w, h);
        thickness = th;
        System.out.println("Woodbox Constructor Called");
    }

    void display() {
        System.out.println("\nDimensions are:");
        System.out.println("Length    : " + length);
        System.out.println("Width     : " + width);
        System.out.println("Height    : " + height);
        System.out.println("Thickness : " + thickness);
    }
}

public class Plateboxwood {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter length, width, height and thickness: ");
        float l = in.nextFloat();
        float w = in.nextFloat();
        float h = in.nextFloat();
        float th = in.nextFloat();

        Woodbox wb = new Woodbox(l, w, h, th);
        wb.display();
    }
}
