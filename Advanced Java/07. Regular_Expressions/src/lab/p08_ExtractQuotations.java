package lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P08_ExtractQuotations {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String text = console.nextLine();
        String regex = "(\\'|\")(.*?)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group(2));
        }
    }
}
