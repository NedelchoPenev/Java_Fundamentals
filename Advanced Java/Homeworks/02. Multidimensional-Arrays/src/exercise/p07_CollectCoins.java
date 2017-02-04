package exercise;

import java.util.Scanner;

public class p07_CollectCoins {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);

        char[][] matrix = new char[4][];
        for (int i = 0; i < 4; i++) {
            char[] line = console.nextLine().toCharArray();
            matrix[i] = new char[line.length];
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j];
            }
        }
        char[] moves = console.nextLine().toCharArray();
        int coinsCollect = 0;
        int wallsHit = 0;

        int row = 0;
        int col = 0;
        char lastMove = ' ';
        for (int i = 0; i < moves.length; i++) {
            if (!isOutMatrix(row, col, matrix)){
                wallsHit++;
                switch (lastMove){
                    case '>':
                        col--;
                        break;
                    case '<':
                        col++;
                        break;
                    case '^':
                        row++;
                        break;
                    case 'V':
                        row--;
                        break;
                }
            } else if (matrix[row][col] == '$'){
                coinsCollect++;
            }

            switch (moves[i]){
                case '>':
                    col++;
                    break;
                case '<':
                    col--;
                    break;
                case '^':
                    row--;
                    break;
                case 'V':
                    row++;
                    break;
            }
            lastMove = moves[i];
        }

        System.out.printf("Coins = %d%n", coinsCollect);
        System.out.printf("Walls = %d%n", wallsHit);
    }

    private static int stayInTheMatrix(int num, char[][] matrix) {
        int number = num;
        if (num < 0){
            number = 0;
        } else if (num > matrix.length){
            return matrix.length;
        }

        return num;
    }

    private static boolean isOutMatrix(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
