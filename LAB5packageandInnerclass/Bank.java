class Bank {

    String bankName = "SBI"; 
    static class InterestCalculator {

        static double calculateSI(double p, double r, double t) {
            return (p * r * t) / 100;
        }

        void show() {
           
            System.out.println("Static nested class cannot access non-static members directly.");
        }
    }

    public static void main(String[] args) {

                double si = InterestCalculator.calculateSI(10000, 5, 2);
        System.out.println("Simple Interest: " + si);

        InterestCalculator obj = new InterestCalculator();
        obj.show();
    }
}
