package exercise;

import java.util.Scanner;

public class p13_BlurFilter {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int blueAmount = Integer.parseInt(input.nextLine());
        String[] size = input.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = input.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] coordinates = input.nextLine().split(" ");
        int rowsCoordinates = Integer.parseInt(coordinates[0]);
        int colsCoordinates = Integer.parseInt(coordinates[1]);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((rowsCoordinates - 1 + i >= 0 && rowsCoordinates - 1 + i < matrix.length) &&
                        colsCoordinates - 1 + j >= 0 && colsCoordinates - 1 + j < matrix[0].length) {
                    matrix[rowsCoordinates - 1 + i][colsCoordinates - 1 + j] += blueAmount;
                }
            }
        }

        for (long[] row : matrix) {
            for (long col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
