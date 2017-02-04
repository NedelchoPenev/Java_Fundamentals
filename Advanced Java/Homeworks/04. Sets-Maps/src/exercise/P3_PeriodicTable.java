package exercise;

import java.util.Scanner;
import java.util.TreeSet;

public class P3_PeriodicTable {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        int lines = Integer.parseInt(console.nextLine());
        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < lines; i++) {
            String[] input = console.nextLine().trim().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                set.add(input[j]);
            }
        }

        for (String s : set) {
            System.out.printf("%s ", s);
        }
    }
}
