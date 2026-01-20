package OOP2.Shresth.intro;

public class Main1 {
    public static void main(String[] args) {
        Human Shresth=new  Human(20,"Shresth");
        Human random1=new  Human(20,"random");
        System.out.println(Shresth.name+" "+Shresth.age+" "+Human.population);
        System.out.println(random1.name+" "+random1.age+" "+Human.population);
     }
}
