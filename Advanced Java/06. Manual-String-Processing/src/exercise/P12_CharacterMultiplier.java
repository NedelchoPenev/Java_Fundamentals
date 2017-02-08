package exercise;

import java.util.Scanner;

public class P12_CharacterMultiplier {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        System.out.println(charMultiplier(input));
    }

    private static int charMultiplier(String[] str) {

        int min = Math.min(str[0].length(), str[1].length());
        String longest;
        if (str[0].length() > str[1].length()) {
            longest = str[0];
        } else {
            longest = str[1];
        }

        int sum = 0;
        for (int i = 0; i < min; i++) {
            sum += str[0].charAt(i) * str[1].charAt(i);
        }
        for (int i = min; i < longest.length(); i++) {
            sum += longest.charAt(i);
        }
        return sum;
    }
}
