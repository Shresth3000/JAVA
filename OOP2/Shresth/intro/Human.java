package OOP2.Shresth.intro;

public class Human {
    int age;
    String name;
    static long population;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        population+=1;
    }
    public Human() {
        this.age = 0;
        this.name = null;
        Human.population+=1;
    }
}
