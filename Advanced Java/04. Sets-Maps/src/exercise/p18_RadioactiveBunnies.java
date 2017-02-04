package exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class p18_RadioactiveBunnies {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] size = console.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];
        ArrayList<Bunny> bunnies = new ArrayList<>();
        int[] playerPosition = new int[2];
        for (int r = 0; r < rows; r++) {
            char[] line = console.nextLine().toCharArray();
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = String.valueOf(line[c]);
                if (line[c] == 'B') {
                    Bunny bunny = new Bunny(r, c);
                    bunny.setNewCreated(false);
                    bunnies.add(bunny);
                } else if (line[c] == 'P') {
                    playerPosition[0] = r;
                    playerPosition[1] = c;
                }
            }
        }

        String playerState = "";
        String gameState = "";
        int lastRow = 0, lastCol = 0;
        while (!gameState.equals("end")) {
            char[] moves = console.nextLine().toCharArray();
            for (int i = 0; i < moves.length; i++) {
                lastRow = playerPosition[0];
                lastCol = playerPosition[1];
                switch (moves[i]) {
                    case 'U':
                        playerPosition[0]--;
                        break;
                    case 'D':
                        playerPosition[0]++;
                        break;
                    case 'R':
                        playerPosition[1]++;
                        break;
                    case 'L':
                        playerPosition[1]--;
                        break;
                }

                playerState = checkPlayerVictory(matrix, playerPosition);
                if (playerState.equals("won")) {
                    gameState = "end";
                    break;
                }
                matrix[lastRow][lastCol] = ".";
                matrix[playerPosition[0]][playerPosition[1]] = "P";
                playerState = checkPlayerLose(bunnies, playerPosition);
                if (playerState.equals("dead")) {
                    lastRow = playerPosition[0];
                    lastCol = playerPosition[1];
                    matrix[playerPosition[0]][playerPosition[1]] = "B";
                    gameState = "end";
                    break;
                }

                int bunnySize = bunnies.size();
                for (int j = 0; j < bunnySize; j++) {
                    Bunny bunny = bunnies.get(j);
                    int bunnyRow = bunny.getRow();
                    int bunnyCol = bunny.getCol();
                    for (int r = 0; r < matrix.length; r++) {
                        for (int c = 0; c < matrix[r].length; c++) {
                            if (isInsideRadius(r, c, bunnyRow, bunnyCol) &&
                                    !bunny.isNewCreated()) {
                                if (matrix[r][c].equals("P")) {
                                    playerState = "dead";
                                    lastRow = r;
                                    lastCol = c;
                                } else if (!matrix[r][c].equals("B")) {
                                    matrix[r][c] = "B";
                                    bunnies.add(new Bunny(r, c));
                                }
                            }
                        }
                    }
                }

                if (playerState.equals("dead")) {
                    gameState = "end";
                    break;
                }
                for (Bunny bunny : bunnies) {
                    bunny.setNewCreated(false);
                }
            }
        }

        for (Bunny bunny : bunnies) {
            int bunnyRow = bunny.getRow();
            int bunnyCol = bunny.getCol();
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    if (matrix[r][c].equals("P")) {
                        matrix[r][c] = ".";
                    }
                    if (isInsideRadius(r, c, bunnyRow, bunnyCol) &&
                            !bunny.isNewCreated() &&
                            !matrix[r][c].equals("B")) {

                        matrix[r][c] = "B";
                    }
                }
            }
        }

        for (String[] row : matrix) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.printf("%s: %d %d", playerState, lastRow, lastCol);
    }

    private static boolean isInsideRadius(int row, int col, int targetRow, int targetCol) {
        if (row == targetRow - 1 && col == targetCol ||
                row == targetRow + 1 && col == targetCol ||
                col == targetCol - 1 && row == targetRow ||
                col == targetCol + 1 && row == targetRow) {
            return true;
        }

        return false;
    }

    private static String checkPlayerLose(ArrayList<Bunny> bunnies, int[] playerPosition) {
        int row = playerPosition[0];
        int col = playerPosition[1];

        for (Bunny bunny : bunnies) {
            int bunnyRow = bunny.getRow();
            int bunnyCol = bunny.getCol();

            if (row == bunnyRow && col == bunnyCol) {
                return "dead";
            }
        }

        return "";
    }

    private static String checkPlayerVictory(String[][] matrix, int[] playerPosition) {
        int row = playerPosition[0];
        int col = playerPosition[1];

        int matrixLength = matrix.length - 1;
        int matrixWidth = matrix[0].length - 1;

        if (row < 0 || row > matrixLength || col < 0 || col > matrixWidth) {
            return "won";
        }

        return "";
    }

    private static class Bunny {

        int row;
        int col;
        boolean isNewCreated;

        private Bunny(int row, int col) {
            this.row = row;
            this.col = col;
            this.isNewCreated = true;
        }

        private int getRow() {
            return row;
        }

        private void setRow(int row) {
            this.row = row;
        }

        private int getCol() {
            return col;
        }

        private void setCol(int col) {
            this.col = col;
        }

        private boolean isNewCreated() {
            return isNewCreated;
        }

        private void setNewCreated(boolean newCreated) {
            isNewCreated = newCreated;
        }
    }
}
