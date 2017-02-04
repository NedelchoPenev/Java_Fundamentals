package exercise;

import java.util.Scanner;
import java.util.Stack;

public class p10_StackFibonacci {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        long number = console.nextInt();
        Stack<Long> fibonacci = new Stack<>();
        fibonacci.push(1L);
        fibonacci.push(1L);

        for (int i = 1; i < number; i++) {
            long last = fibonacci.pop();
            long next = fibonacci.peek() + last;

            fibonacci.push(last);
            fibonacci.push(next);
        }

        System.out.println(fibonacci.peek());
    }
}

