package exercise;

import java.util.Scanner;

public class p02_MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        String[] size = input.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int middleIndex = i + j;
                char firstAndLast = alphabet[i];
                char middle = alphabet[middleIndex];
                String word = String.valueOf(firstAndLast) + String.valueOf(middle) + String.valueOf(firstAndLast);
                matrix[i][j] = word;
            }
        }

        for (String[] row : matrix) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
