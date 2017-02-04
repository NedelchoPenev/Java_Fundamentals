package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p16_TargetPractice {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        int[] size = Arrays.stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int row = size[0];
        int col = size[1];

        char[] snake = console.nextLine().toCharArray();
        int[] shot = Arrays.stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int shotRow = shot[0];
        int shotCol = shot[1];
        int shotRadius = shot[2];

        char[][] matrix = sortSnake(row, col, snake);
        matrix = shotSnake(shotRow, shotCol, shotRadius, matrix);
        matrix = rearrangeMatrix(matrix);

        for (char[] rows : matrix) {
            for (char mcol : rows) {
                System.out.print(mcol);
            }
            System.out.println();
        }
    }

    private static char[][] rearrangeMatrix(char[][] matrix) {

        for (int row = matrix.length - 1; row >= 0; row--)
        {
            for (int column = 0; column < matrix[row].length; column++)
            {
                if (matrix[row][column] != ' ')
                {
                    continue;
                }

                int currentRow = row - 1;
                while (currentRow >= 0)
                {
                    if (matrix[currentRow][column] != ' ')
                    {
                        matrix[row][column] = matrix[currentRow][column];
                        matrix[currentRow][column] = ' ';
                        break;
                    }

                    currentRow--;
                }
            }
        }
        return matrix;
    }

    private static char[][] shotSnake(int shotRow, int shotCol, int shotRadius, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[row].length; col++)
            {
                if (IsInsideRadius(row, col, shotRow, shotCol, shotRadius))
                {
                    matrix[row][col] = ' ';
                }
            }
        }

        return matrix;
    }

    private static boolean IsInsideRadius(int row, int col, int targetRow, int targetCol, int radius){
        int deltaRow = row - targetRow;
        int deltaCol = col - targetCol;

        return ((deltaRow * deltaRow) + (deltaCol * deltaCol)) <= (radius * radius);
    }

    private static char[][] sortSnake(int row, int col, char[] snake) {
        char[][] matrix = new char[row][col];
        int index = 0;
        int countRows = 0;

        for (int r = row - 1; r >= 0; r--) {
            if (countRows % 2 != 0){
                for (int c = 0; c < col; c++) {
                    matrix[r][c] = snake[index++ % snake.length];
                }
            } else {
                for (int c = col - 1; c >= 0; c--) {
                    matrix[r][c] = snake[index++ % snake.length];
                }
            }
            countRows++;
        }

        return matrix;
    }
}
