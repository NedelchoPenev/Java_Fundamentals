package exercise;

import java.util.Scanner;

public class P6_CountSubstringOccurrences {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine().toLowerCase();
        String searchedWord = console.nextLine().toLowerCase();
        int count = 0;
        int poss = text.indexOf(searchedWord);

        while (poss >= 0 && poss < text.length()) {
            count++;
            poss = text.indexOf(searchedWord, poss + 1);
        }

        System.out.println(count);
    }
}
