package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p01_ReversingStrings {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String input = console.nextLine();

        ArrayDeque<Character> reversed = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            reversed.push(ch);
        }

        for (Character character : reversed) {
            System.out.print(character);
        }
    }
}
