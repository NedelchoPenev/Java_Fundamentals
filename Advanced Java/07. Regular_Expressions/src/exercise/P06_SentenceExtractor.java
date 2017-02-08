package exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_SentenceExtractor {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String word = console.nextLine();
        Pattern pattern = Pattern.compile("[^!.?]*\\b" + word + "\\b[^.?!]*[.?!]");
        String input = console.nextLine();
        Matcher match = pattern.matcher(input);

        while (match.find()){
            System.out.println(match.group().trim());
        }
    }
}
