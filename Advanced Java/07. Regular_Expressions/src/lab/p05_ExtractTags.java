package lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_ExtractTags {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);

        Pattern pattern = Pattern.compile("<.*?>");

        while (true) {
            String input = console.nextLine();
            if ("END".equals(input)) {
                break;
            }

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
}
