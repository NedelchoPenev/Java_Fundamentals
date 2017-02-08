package exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12_SemanticHtml {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String openTag = "(?<replace><div).+(?<remove>(id|class)\\s*?=\\s*?\\\"" +
                "(?<word>main|header|nav|article|section|aside|footer)\\\").+>?";
        String closeTag = "<\\/div>\\s*(?<delete><!--\\s*?(?<word>main|header|nav|article|section|aside|footer)\\s*?-->)";

        Pattern patternOpen = Pattern.compile(openTag);
        Pattern patternClose = Pattern.compile(closeTag);

        while (true) {
            String line = console.nextLine();
            if ("END".equals(line)) {
                break;
            }

            Matcher matcherOpen = patternOpen.matcher(line);
            Matcher matcherClose = patternClose.matcher(line);

            if (matcherOpen.find()){
                String result = matcherOpen.group()
                        .replace(matcherOpen.group("replace"), "<" + matcherOpen.group("word"))
                        .replace(matcherOpen.group("remove"), "");
                System.out.println(result.replaceAll("\\s+", " ").replaceAll("\\s+>", ">"));
            } else if (matcherClose.find()){
                String result = "</" + matcherClose.group("word") + ">";
                System.out.println(result);
            } else {
                System.out.println(line);
            }
        }
    }
}
