package exercise;

import java.util.Scanner;

public class p10_CharacterMultiplier {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String firstInput = console.next();
        String secondInput = console.next();

        int sum = sumReturn(firstInput, secondInput);
        System.out.println(sum);
    }

    private static int sumReturn(String one, String two) {
        int diff = two.length();
        if (one.length() < two.length()) {
            String temp = one;
            one = two;
            two = temp;
            diff = two.length();
        }

        int sum = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.length() > two.length() && diff <= i) {
                    sum += one.charAt(i);
            }else {
                sum += one.charAt(i) * two.charAt(i);
            }
        }
        return sum;
    }
}
