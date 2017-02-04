package exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class p10_PlusRemoveTests {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);

        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        while (true) {
            String input = console.nextLine();
            if (input.equals("END")) {
                break;
            }

            char[] chars = input.toCharArray();
            ArrayList<String> line = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                line.add(String.valueOf(chars[i]));
            }

            matrix.add(line);
        }

        ArrayList<Integer> indexesForReplace = new ArrayList<>();
        for (int row = 0; row < matrix.size() - 1; row++) {
            for (int col = 0; col < matrix.get(row).size() - 1; col++) {
                if (row - 1 >= 0 && row + 1 < matrix.size() &&
                        col < matrix.get(row - 1).size() && col < matrix.get(row + 1).size() &&
                        col - 1 >= 0 && col + 1 < matrix.get(row).size()){

                    if (matrix.get(row).get(col).equalsIgnoreCase(matrix.get(row - 1).get(col)) &&
                            matrix.get(row).get(col).equalsIgnoreCase(matrix.get(row + 1).get(col)) &&
                            matrix.get(row).get(col).equalsIgnoreCase(matrix.get(row).get(col - 1)) &&
                            matrix.get(row).get(col).equalsIgnoreCase(matrix.get(row).get(col + 1))){

                        indexesForReplace.add(row);
                        indexesForReplace.add(col);
                        indexesForReplace.add(row - 1);
                        indexesForReplace.add(col);
                        indexesForReplace.add(row + 1);
                        indexesForReplace.add(col);
                        indexesForReplace.add(row);
                        indexesForReplace.add(col - 1);
                        indexesForReplace.add(row);
                        indexesForReplace.add(col + 1);

                    }
                }
            }
        }

        for (int i = 0; i < indexesForReplace.size() - 1; i+=2) {
            int row = indexesForReplace.get(i);
            int col = indexesForReplace.get(i + 1);

            matrix.get(row).set(col, " ");
        }

        for (ArrayList<String> strings : matrix) {
            for (String string : strings) {
                if (!string.equals(" ")) {
                    System.out.printf("%s", string);
                }
            }
            System.out.println();
        }
    }
}
