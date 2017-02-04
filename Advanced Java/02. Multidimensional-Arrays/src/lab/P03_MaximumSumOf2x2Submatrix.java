package lab;

import java.util.Scanner;

public class P03_MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String[] size = scanner.nextLine().split(", ");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] numbers = scanner.nextLine().split(", ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int sum = Integer.MIN_VALUE;
        int[][] smallMatrix = new int[2][2];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                if (currentSum > sum){
                    sum = currentSum;
                    smallMatrix[0][0] = matrix[i][j];
                    smallMatrix[0][1] = matrix[i][j +1];
                    smallMatrix[1][0] = matrix[i +1][j];
                    smallMatrix[1][1] = matrix[i+ 1][j+1];
                }
            }
        }

        for (int[] ints : smallMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
