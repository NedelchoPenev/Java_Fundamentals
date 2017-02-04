package exercise;

import java.util.Scanner;

public class p6_ConvertFromBase7ToDecimal {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String baseSeven = Integer.toString(console.nextInt(7), 10);
        System.out.println(baseSeven);
    }
}
