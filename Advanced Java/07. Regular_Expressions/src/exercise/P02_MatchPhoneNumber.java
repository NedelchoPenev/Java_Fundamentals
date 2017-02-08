package exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MatchPhoneNumber {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        Pattern pattern = Pattern.compile
                ("(^\\+359+\\s?\\d{1}\\s?\\d{3}\\s?\\d{4}|^\\+359+-?\\d{1}-?\\d{3}-?\\d{4})\\b");

        while (true){
            String input = console.nextLine();
            if (input.equals("end")){
                break;
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
}
