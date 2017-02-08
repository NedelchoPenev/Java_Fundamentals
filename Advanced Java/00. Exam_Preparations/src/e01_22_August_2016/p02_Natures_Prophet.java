package e01_22_August_2016;

import java.util.Scanner;

public class p02_Natures_Prophet {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] size = console.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] garden = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                garden[i][j] = 0;
            }
        }
        
        while (true) {
            String input = console.nextLine();
            if ("Bloom Bloom Plow".equals(input)) {
                break;
            }
            String[] split = input.split("\\s+");
            int targetRow = Integer.parseInt(split[0]);
            int targetCol = Integer.parseInt(split[1]);

            for (int i = 0; i < rows; i++) {
                garden[i][targetCol]++;
            }

            for (int i = 0; i < cols; i++) {
                if (i == targetCol){
                    continue;
                }
                garden[targetRow][i]++;
            }
        }

        for (int[] row : garden) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
