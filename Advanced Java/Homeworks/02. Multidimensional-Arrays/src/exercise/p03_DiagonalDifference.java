package exercise;

import java.util.Scanner;

public class p03_DiagonalDifference {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        int size = Integer.parseInt(console.nextLine());

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] input = console.nextLine().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        int primary = 0;
        for (int i = 0; i < size; i++) {
            primary += matrix[i][i];
        }

        int secondary = 0;
        for (int i = size - 1; i >= 0; i--) {
            secondary += matrix[i][size - 1 - i];
        }

        System.out.println(Math.abs(primary - secondary));
    }
}
