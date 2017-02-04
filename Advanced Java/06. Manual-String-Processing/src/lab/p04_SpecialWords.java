package lab;

import java.util.HashMap;
import java.util.Scanner;

public class p04_SpecialWords {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] searchedWords = console.nextLine().split("\\s+");
        String[] text = console.nextLine().split("\\s+");

        HashMap<String, Integer> occurrence = new HashMap<>();
        for (int i = 0; i < searchedWords.length; i++) {
            occurrence.put(searchedWords[i], 0);
            for (int j = 0; j < text.length; j++) {
                if (searchedWords[i].equals(text[j])) {
                    occurrence.put(searchedWords[i], occurrence.get(searchedWords[i]) + 1);
                }
            }
        }

        for (String word : occurrence.keySet()) {
            System.out.printf("%s - %d%n", word, occurrence.get(word));
        }
    }
}
