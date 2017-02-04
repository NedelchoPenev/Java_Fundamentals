package exercise;

import java.util.Scanner;

public class p5_ConvertFromDecimalSystemToBase7 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num = console.nextInt();
        System.out.println(Integer.toString(num, 7));
    }
}
