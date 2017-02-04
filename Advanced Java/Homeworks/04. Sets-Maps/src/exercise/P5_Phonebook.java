package exercise;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P5_Phonebook {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\w.*)-(.*)");

        while (true){
            String input = console.nextLine();
            if (input.equals("search")){
                break;
            }

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group(1);
                String phone = matcher.group(2);
                map.put(name, phone);
            }
        }

        while (true){
            String input = console.nextLine();
            if (input.equals("stop")){
                break;
            }
            if (map.containsKey(input)){
                System.out.printf("%s -> %s%n", input, map.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
