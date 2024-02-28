import java.util.Random;

public class Main {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int size = 2000;
        Random random = new Random(20000);

        int[][] A = generateRandomMatrix(size, size, random);
        int[][] B = generateRandomMatrix(size, size, random);
        int[][] C = generateRandomMatrix(size, size, random);
        int[][] D = generateRandomMatrix(size, size, random);

        int[][] X = multiply(A, B);
        int[][] Y = multiply(C, D);
        int[][] Z = multiply(X, Y);

        System.out.println("Sum of X: " + returnSum(X));
        System.out.println("Sum of Y: " + returnSum(Y));
        System.out.println("Sum of Z: " + returnSum(Z));
    }

    public static int[][] generateRandomMatrix(int rows, int cols, Random random) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 1000 - random.nextInt(2000);
            }
        }
        return matrix;
    }

    public static long returnSum(int[][] A) {
        long sum = 0L;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }
}
