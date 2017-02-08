package exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_MatchFullName {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\b^([A-Z][a-z]+\\s[A-Z][a-z]+)\\b");

        while (true){
            String input = console.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (input.equals("end")){
                break;
            }

            if (matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
}
