package lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_ExtractIntegerNumbers {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String text = console.nextLine();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
