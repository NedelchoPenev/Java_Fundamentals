package exercise;

import java.util.Scanner;

public class P10_UnicodeCharacters {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String text = console.nextLine();

        for (int i = 0; i < text.length(); i++) {
            System.out.printf("\\u00%x", ((int) text.charAt(i)));
        }
    }
}
