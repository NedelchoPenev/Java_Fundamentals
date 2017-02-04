package lab;

import java.util.Scanner;

public class P02_SumMatrixElements {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String[] size = scanner.nextLine().split(", ");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        int sum = 0;
        for (int i = 0; i < row; i++) {
            String[] numbers = scanner.nextLine().split(", ");
            for (int j = 0; j < col; j++) {
                sum += Integer.parseInt(numbers[j]);
            }
        }

        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);
    }
}
