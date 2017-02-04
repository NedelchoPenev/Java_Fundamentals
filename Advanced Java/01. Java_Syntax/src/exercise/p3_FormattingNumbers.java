package exercise;

import java.util.Scanner;

public class p3_FormattingNumbers {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        double b = console.nextDouble();
        double c = console.nextDouble();

        String hex = Integer.toHexString(a).toUpperCase();
        int binary = Integer.parseInt(Integer.toBinaryString(a));

        System.out.printf("|%1$-10s|%2$010d|%3$10.2f|%4$-10.3f|", hex, binary, b, c);

    }
}
