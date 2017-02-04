package exercise;

import java.util.Scanner;

public class p04_SquaresInMatrix {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] size = console.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = console.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }

        int counter = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1] &&
                        matrix[i][j] == matrix[i + 1][j] &&
                        matrix[i][j] == matrix[i + 1][j + 1]){
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
