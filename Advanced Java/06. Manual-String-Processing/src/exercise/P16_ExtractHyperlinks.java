package exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P16_ExtractHyperlinks {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?:<a)(?:[\\s\\n_0-9a-zA-Z=\"\"()]*?.*?)(?:href([\\s\\n]*)?=(?:['\"\"\\s\\n]*)?)([a-zA-Z:#\\/._\\-0-9!?=^+]*(\\([\"\"'a-zA-Z\\s.()0-9]*\\))?)(?:[\\s\\na-zA-Z=\"\"()0-9]*.*?)?(?:\\>)");
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = console.nextLine();
            if (input.equals("END")) {
                break;
            }
            sb.append(input);
        }

        Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()) {
            if (!matcher.group(2).equals("fake")) {
                System.out.println(matcher.group(2));
            }
        }
    }
}