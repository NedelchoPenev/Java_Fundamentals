package lab;

import java.util.ArrayList;
import java.util.Scanner;

public class P04_GroupNumbers {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(", ");
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(0, new ArrayList<>());
        matrix.add(1, new ArrayList<>());
        matrix.add(2, new ArrayList<>());

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            matrix.get(Math.abs(num % 3)).add(num);
        }

        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
