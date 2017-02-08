package exercise;

import java.util.Scanner;

public class P9_TextFilter {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String[] words = console.nextLine().split(", ");
        String text = console.nextLine();
        String result = text;

        for (int i = 0; i < words.length; i++) {

            String replacement = "";
            for (int j = 0; j < words[i].length(); j++) {
                replacement += "*";
            }

            result = result.replaceAll(words[i], replacement);
        }

        System.out.println(result);
    }
}
