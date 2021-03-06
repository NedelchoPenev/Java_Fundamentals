package exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_ExtractEmails {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String input = console.nextLine();
        Pattern pattern = Pattern.compile
                ("(?:(?<=\\s|^))[a-z\\d]+[-._]?[a-z\\d]+@(?:[a-z]+[.-]?[a-z]+[.-]?[a-z]+)+\\.[a-z]+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
