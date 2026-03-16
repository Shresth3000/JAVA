interface Greeting {
    void sayHello();
}

class TestGreeting {
    public static void main(String[] args) {

        
        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello Shresth! Welcome to Java Programming.");
            }
        };

        g.sayHello();
    }
}
