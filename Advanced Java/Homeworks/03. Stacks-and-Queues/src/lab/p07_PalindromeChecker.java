package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p07_PalindromeChecker {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String input = console.nextLine();

        ArrayDeque<Character> letters = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
           letters.offer(ch);
        }

        while (letters.size() > 1){
            char first = letters.poll();
            char last = letters.pollLast();

            if (first != last){
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }
}
