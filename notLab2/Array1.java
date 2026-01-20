package notLab2;
class Array1 {
    public static void main(String[] args) {
        if (args.length > 3) {return;}
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        int max = z > (x > y ? x : y) ? z : (x > y ? x : y);
        System.out.println("Maximum = " + max);
    }
}
