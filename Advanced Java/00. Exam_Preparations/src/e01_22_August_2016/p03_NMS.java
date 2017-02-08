package e01_22_August_2016;

import java.util.Scanner;

public class p03_NMS {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);

        StringBuilder words = new StringBuilder();
        while (true) {
            String input = console.nextLine();
            if ("---NMS SEND---".equals(input)) {
                break;
            }

            words.append(input);
        }

        String delimiter = console.nextLine();
        for (int i = 0; i < words.length() - 1; i++) {
            String firstLetter = String.valueOf(words.charAt(i)).toLowerCase();
            String secondLetter = String.valueOf(words.charAt(i + 1)).toLowerCase();

            if (firstLetter.charAt(0) > secondLetter.charAt(0)){
                words.insert(i + 1, delimiter);
                i += delimiter.length();
            }
        }

        System.out.println(words.toString());
    }
}
