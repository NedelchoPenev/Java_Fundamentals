package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P14_LettersChangeNumbers {

    public static void main(String[] args) {
        List<Character> alphabet = Arrays.asList('0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        double sum = 0;

        for (int i = 0; i < input.length; i++) {
            String numbersStr = input[i].substring(1, input[i].length() - 1);
            double numbers = Integer.parseInt(numbersStr);

            if (Character.isUpperCase(input[i].charAt(0))){
                double divider = alphabet.indexOf(input[i].toLowerCase().charAt(0));
                sum += numbers / divider;
            } else {
                double multiplier = alphabet.indexOf(input[i].charAt(0));
                sum += numbers * multiplier;
            }

            if (Character.isUpperCase(input[i].charAt(input[i].length() - 1))){
                double subtractor = alphabet.indexOf(input[i].toLowerCase().charAt(input[i].length() - 1));
                sum = sum - subtractor;
            } else {
                double add = alphabet.indexOf(input[i].charAt(input[i].length() - 1));
                sum = sum + add;
            }
        }

        System.out.printf("%.2f",  sum);
    }
}
