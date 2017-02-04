package exercise;

import java.util.Scanner;

public class p9_RecursiveFibonacci {

    private static long[] fibonacci;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        fibonacci = new long[number + 1];
        System.out.println(fibonacciRec(number));
    }

    private static long fibonacciRec(int n) {
        if (n <= 1) {
            return 1;
        } if (fibonacci[n] != 0) {
            return fibonacci[n];
        }
        fibonacci[n] = fibonacciRec(n - 1) + fibonacciRec(n - 2);
        return fibonacci[n];
    }
}
