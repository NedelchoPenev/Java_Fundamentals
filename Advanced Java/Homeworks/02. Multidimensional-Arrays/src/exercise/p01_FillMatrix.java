package exercise;

import java.util.Scanner;

public class p01_FillMatrix {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        String[] line = input.nextLine().split("\\W+");
        int size = Integer.parseInt(line[0]);
        String pattern = line[1];

        if (pattern.equals("A")){
            sortVertical(size);
        } else {
            sortSnake(size);
        }
    }

    private static void sortVertical(int size) {
        for (int i = 1; i < size + 1; i++) {
            int filler = i;
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ", filler);
                filler += size;
            }
            System.out.println();
        }
    }

    private static void sortSnake(int size) {
        int[][] matrix = new int[size][size];
        int filler = 1;

        for (int i = 0; i < size; i++) {

            if (i % 2 == 0){
                for (int j = 0; j < size; j++) {
                    matrix[j][i] = filler++;
                }
            } else {
                for (int j = size - 1; j >= 0; j--) {
                    matrix[j][i] = filler++;
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int cols : rows) {
                System.out.printf("%d ", cols);
            }
            System.out.println();
        }
    }
}
