package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p19_Crossfire {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] size = console.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int filler = 1;
        for (int i = 0; i < row; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < col; j++) {
                matrix.get(i).add(filler++);
            }
        }

        while (true) {
            String input = console.nextLine();
            if ("Nuke it from orbit".equals(input)) {
                break;
            }

            String[] split = input.split("\\s+");
            int fireRow = Integer.parseInt(split[0]);
            int fireCol = Integer.parseInt(split[1]);
            int radius = Integer.parseInt(split[2]);

            int startRow = fireRow - radius;
            int startCol = fireCol - radius;
            int endRow = fireRow + radius;
            int endCol = fireCol + radius;

            for (int r = startRow; r <= endRow; r++) {
                if (isInsideMatrix(r, fireCol, matrix)){
                    matrix.get(r).set(fireCol, -1);
                }
            }

            for (int c = startCol; c <= endCol; c++) {
                if (isInsideMatrix(fireRow, c, matrix)){
                    matrix.get(fireRow).set(c, -1);
                }
            }

            for (ArrayList<Integer> aMatrix : matrix) {
                aMatrix.removeAll(Collections.singleton(-1));
            }

            matrix.removeAll(Arrays.asList(new ArrayList<>()));
        }

        for (ArrayList<Integer> rows : matrix) {
            for (Integer cols : rows) {
                System.out.printf("%d ", cols);
            }
            System.out.println();
        }
    }

    private static boolean isInsideMatrix(int row, int col, ArrayList<ArrayList<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
