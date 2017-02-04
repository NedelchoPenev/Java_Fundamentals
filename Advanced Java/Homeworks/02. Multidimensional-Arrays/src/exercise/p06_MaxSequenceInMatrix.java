package exercise;

import java.util.Scanner;

public class p06_MaxSequenceInMatrix {

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

        int counter = 0;
        String longestSequence = "";
        for (int i = 0; i < rows; i++) {
            int currentCounter = 1;
            for (int j = 0; j < cols -1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1])){
                    currentCounter++;
                } else {
                    if (currentCounter > counter){
                        counter = currentCounter;
                        longestSequence = matrix[i][j];
                    }
                    currentCounter = 0;
                }

                if (currentCounter > counter){
                    counter = currentCounter;
                    longestSequence = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            int currentCounter = 1;
            for (int j = 0; j < rows -1; j++) {
                if (matrix[j][i].equals(matrix[j + 1][i])){
                    currentCounter++;
                } else {
                    if (currentCounter > counter){
                        counter = currentCounter;
                        longestSequence = matrix[i][j];
                    }
                    currentCounter = 1;
                }

                if (currentCounter > counter){
                    counter = currentCounter;
                    longestSequence = matrix[j][i];
                }
            }
        }

        for (int i = 0; i < cols - 1; i++) {
            int currentCounter = 1;
            for (int j = 0; j < rows - 1; j++) {
                if (j < rows - 1 && j < cols - 1) {
                    if (matrix[j][j].equals(matrix[j + 1][j + 1])) {
                        currentCounter++;
                    } else {
                        if (currentCounter > counter) {
                            counter = currentCounter;
                            longestSequence = matrix[i][j];
                        }
                        currentCounter = 1;
                    }
                }

                if (currentCounter > counter){
                    counter = currentCounter;
                    longestSequence = matrix[j][j];
                }
            }
        }

        for (int i = 0; i < counter; i++) {
            System.out.printf("%s, ", longestSequence);
        }
    }
}
