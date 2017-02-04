package lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01_ReadSortAndPrintArray {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        String[] names = new String[lines];

        for (int i = 0; i < lines; i++) {
            names[i] = scanner.nextLine();
        }

        Arrays.sort(names);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
