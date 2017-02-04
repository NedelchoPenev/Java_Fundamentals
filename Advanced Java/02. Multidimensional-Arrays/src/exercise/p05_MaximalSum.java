package exercise;

import java.util.Scanner;

public class p05_MaximalSum {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] size = console.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = console.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] +
                        matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2] +
                        matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];

                if (currentSum > maxSum){
                    maxSum = currentSum;
                    startRow = i;
                    startCol = j;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
