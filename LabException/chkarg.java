
class CheckArgument extends Exception {
    CheckArgument(String msg) {
        super(msg);
    }
}

public class  chkarg{
    public static void main(String[] args) {

        try {
                       if (args.length < 4) {
                throw new CheckArgument("CheckArgument");
            }

            int sum = 0;

                       for (int i = 0; i < 4; i++) {
                int num = Integer.parseInt(args[i]);
                sum += num * num;
            }

            System.out.println(sum);

        } catch (CheckArgument e) {
            System.out.println("Exception occurred - " + e.getMessage());
        }
    }
}
