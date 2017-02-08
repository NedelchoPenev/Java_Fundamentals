package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class p03_CountUpperCaseWords {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] text = console.readLine().trim().split("\\s+");
        Predicate<String> isItStartUpper = s -> Character.isUpperCase(s.charAt(0));

        List<String> words = new ArrayList<>();

        for (String word : text) {
            if (!word.equals("") && isItStartUpper.test(word)){
                words.add(word);
            }
        }
        System.out.println(words.size());
        words.forEach(System.out::println);
    }
}
