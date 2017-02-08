package exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10_QueryMess {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([^?=&]+)=([^?=&]+)");

        while (true) {
            String input = console.nextLine();
            if (input.equals("END")) {
                break;
            }
            LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();

            input = input.replaceAll("\\+|%20+", " ");
            input = input.replaceAll("\\s+", " ");

            String[] line = input.split("&");
            for (String word : line) {
                Matcher matcher = pattern.matcher(word);
                if (matcher.find()){
                    String key = matcher.group(1).trim();
                    String value = matcher.group(2).trim();
                    if (!map.containsKey(key)){
                        map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(value);
                }
            }
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                System.out.printf("%s=%s", entry.getKey(), entry.getValue());
            }
            System.out.println();
        }
    }
}
