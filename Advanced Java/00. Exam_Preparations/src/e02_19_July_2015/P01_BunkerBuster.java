package e02_19_July_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_BunkerBuster {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] size = console.readLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] input = console.readLine().split("\\s++");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (true) {
            String input = console.readLine();
            if ("cease fire!".equals(input)) {
                break;
            }
            String[] split = input.split("\\s+");
            int targetRow = Integer.parseInt(split[0]);
            int targetCol = Integer.parseInt(split[1]);
            int power = split[2].charAt(0);
            matrix[targetRow][targetCol] -= power;
            int reducetPower = (int)Math.ceil( power/ 2.0);

            matrix = bombDamage(matrix, targetRow, targetCol, reducetPower);
        }
        int destroyedCells = 0;
        destroyedCells += getDestroyedCells(matrix, destroyedCells);

        printResult(rows, cols, destroyedCells);
    }

    private static int getDestroyedCells(int[][] matrix, int destroyedCells) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] <= 0){
                    destroyedCells++;
                }
            }
        }
        return destroyedCells;
    }

    private static void printResult(int rows, int cols, int destroyedCells) {
        System.out.printf("Destroyed bunkers: %d%n", destroyedCells);
        double matrixSize = rows * cols;
        double damage = (destroyedCells / matrixSize) * 100;
        System.out.printf("Damage done: %.1f %%", damage);
    }

    private static int[][] bombDamage(int[][] matrix, int targetRow, int targetCol, double power) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = targetRow - 1 + i;
                int col = targetCol - 1 + j;
                if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) {
                    if (row == targetRow && col ==targetCol){
                        continue;
                    }
                    matrix[row][col] -= power;
                }
            }
        }
        return matrix;
    }
}
