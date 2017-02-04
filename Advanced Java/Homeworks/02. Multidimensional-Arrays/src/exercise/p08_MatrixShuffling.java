package exercise;

import java.util.Scanner;

public class p08_MatrixShuffling {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] size = console.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String [][] matrix = new String [rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = console.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j];
            }
        }

        while (true) {
            String input = console.nextLine();
            if (input.equals("END")) {
                break;
            }

            String[] lines = input.split("\\s+");
            if (lines[0].equals("swap") && lines.length == 5){
                int row1 = Integer.parseInt(lines[1]);
                int col1 = Integer.parseInt(lines[2]);
                int row2 = Integer.parseInt(lines[3]);
                int col2= Integer.parseInt(lines[4]);

                if (row1 < 0 || row1 > rows || row2 < 0 || row2 > rows ||
                        col1 < 0 || col1 > cols || col1 < 0 || col1 > cols){
                    System.out.println("Invalid input!");
                } else {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    for (String[] strings : matrix) {
                        for (String string : strings) {
                            System.out.printf("%s ", string);
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
