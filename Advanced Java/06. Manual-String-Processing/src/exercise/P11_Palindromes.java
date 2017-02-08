package exercise;

import java.text.Collator;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

public class P11_Palindromes {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String[] text = console.nextLine().split("\\W+");
        Collator collator = Collator.getInstance(Locale.UK);
        TreeSet<String> set = new TreeSet<>(collator);

        for (String word : text) {

            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)){
                set.add(word);
            }
        }

        System.out.println(set);
    }
}
