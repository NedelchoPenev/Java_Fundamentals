package lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_ValidUsernames {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String regex = "^[A-Za-z0-9_-]{3,16}$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String input = console.nextLine();
            if ("END".equals(input)) {
                break;
            }

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }
}
