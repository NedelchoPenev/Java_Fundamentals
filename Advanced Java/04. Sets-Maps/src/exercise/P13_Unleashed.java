package exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13_Unleashed {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> map = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(\\D+)\\s@(\\D+)\\s(\\d+)\\s(\\d+)");

        while (true){
            String input = console.nextLine();
            if (input.equals("End")){
                break;
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String singer = matcher.group(1);
                String venue = matcher.group(2);
                long money = Long.parseLong(matcher.group(3)) *
                        Long.parseLong(matcher.group(4));

                if (!map.containsKey(venue)){
                    map.put(venue, new LinkedHashMap<>());
                    map.get(venue).put(singer, money);
                } else {
                    if (!map.get(venue).containsKey(singer)){
                        map.get(venue).put(singer, money);
                    } else {
                        long oldValue = map.get(venue).get(singer);
                        map.get(venue).put(singer, oldValue + money);
                    }
                }
            }
        }

        for (String venue : map.keySet()) {
            System.out.println(venue);
            LinkedHashMap<String, Long> singers = map.get(venue);
            singers.entrySet().stream()
                    .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(print -> System.out.printf("#  %s -> %d%n",
                            print.getKey(), print.getValue()));
        }
    }
}
