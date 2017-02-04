package lab;

import java.util.Scanner;

public class P05_PascalTriangle {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        long[][] pascalTriangle = new long[rows][];
        int currentWidth = 1;
        for (int currentHeight = 0; currentHeight < rows; currentHeight++) {
            pascalTriangle[currentHeight] = new long[currentWidth];
            long[] currentRow = pascalTriangle[currentHeight];
            currentWidth++;
            currentRow[0] = 1;
            currentRow[currentRow.length - 1] = 1;
            if (currentRow.length > 2)
                for (int i = 1; i < currentRow.length - 1; i++) {
                    long[] previousRow = pascalTriangle[currentHeight - 1];
                    long previousRowSum = previousRow[i] + previousRow[i - 1];
                    currentRow[i] = previousRowSum;
                }

        }

        for (long[] pascalRows : pascalTriangle) {
            for (long num : pascalRows) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
