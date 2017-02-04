package exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class p12_StringMatrixRotationTests {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String rotate = console.findInLine("\\d+");
        console.nextLine();

        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        int longestLine = 0;
        while (true) {
            String input = console.nextLine();
            if (input.equals("END")) {
                break;
            }

            ArrayList<Character> line = new ArrayList<>();
            for (char ch : input.toCharArray()) {
                line.add(ch);
            }
            matrix.add(line);
            int sizeOfLine = line.size();
            longestLine = Math.max(longestLine, sizeOfLine);
        }

        for (int i = 0; i < matrix.size(); i++) {
            int num = longestLine - matrix.get(i).size();
            for (int j = 0; j < num; j++) {
                matrix.get(i).add(' ');
            }
        }

        Character[][] newMatrix = new Character[matrix.size()][];
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Character> row = matrix.get(i);
            newMatrix[i] = row.toArray(new Character[row.size()]);
        }

        int timeToRotate = Integer.parseInt(rotate) / 90;
        for (int i = 0; i < timeToRotate; i++) {
            newMatrix = rotateMatrix(newMatrix);
        }

        for (Character[] chars : newMatrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static Character[][] rotateMatrix(Character[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Character[][] newMatrix = new Character[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                newMatrix[c][rows - 1 - r] = matrix[r][c];
            }
        }

        return newMatrix;
    }
}
