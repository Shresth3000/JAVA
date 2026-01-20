import java.util.*;
class Fifth{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        int left = 0, right = 0;
        System.out.println("Enter 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = in.nextInt();
                if (i == j) {
                    left += matrix[i][j];
                }
                if (i + j == 2) {
                    right += matrix[i][j];
                }
            }
        }
        System.out.println("Left = " + left);
        System.out.println("Right = " + right);
    }
}