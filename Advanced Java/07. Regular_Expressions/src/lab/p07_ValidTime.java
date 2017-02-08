package lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_ValidTime {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String regex = "^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String input = console.nextLine();
            if ("END".equals(input)) {
                break;
            }

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                if (isTimeCorrect(matcher)) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            } else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean isTimeCorrect(Matcher matcher){
        int hours = Integer.parseInt(matcher.group(1));
        int minutes = Integer.parseInt(matcher.group(2));
        int seconds = Integer.parseInt(matcher.group(3));

        return (hours >= 1 && hours <= 12) && (minutes >= 0 && minutes <= 59) && (seconds >= 0 && seconds <= 59);

    }
}
