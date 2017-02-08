package exercise;

import java.util.Scanner;

public class P03_SeriesOfLetters {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String input = console.nextLine();

        input = input.replaceAll("(.)\\1+", "$1");
        System.out.println(input);
    }
}
