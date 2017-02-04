package exercise;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p08_SumOfAllValues {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String keysString = console.nextLine();

        String startKey = "^([A-Za-z_]+)(?=\\d+)";
        String endKey = "(?<=\\d)([A-Za-z_]+)$";

        String startRegex = "";
        String middleRegex = "([0-9.]+)";
        String endRegex = "";

        Pattern patternStart = Pattern.compile(startKey);
        Matcher matcherStart = patternStart.matcher(keysString);
        if (matcherStart.find()){
            startRegex = matcherStart.group(1);
        }

        Pattern patternEnd = Pattern.compile(endKey);
        Matcher matcherEnd = patternEnd.matcher(keysString);
        if (matcherEnd.find()){
            endRegex = matcherEnd.group(1);
        }

        if (startRegex.isEmpty() || endRegex.isEmpty()){
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String text = console.nextLine();
        String regex = startRegex + middleRegex + endRegex;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        double sum = 0;

        while (matcher.find()){
            sum += Double.parseDouble(matcher.group(1));
        }

        if (sum == 0){
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.printf("<p>The total value is: <em>%s</em></p>", decimalFormat.format(sum));
        }
    }
}
