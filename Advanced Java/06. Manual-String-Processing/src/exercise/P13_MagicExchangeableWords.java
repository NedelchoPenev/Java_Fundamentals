package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class P13_MagicExchangeableWords {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);

        String first = console.next();
        String second = console.next();

        System.out.println(isTrue(first, second));
    }

    private static boolean isTrue (String first, String second){
        HashMap<Character, Character> map = new HashMap<>();
        int min = Math.min(first.length(), second.length());
        String shorter = "";
        String longest = "";
        if (first.length() > second.length()){
            longest = first;
            shorter = second;
        } else if (second.length() > first.length()){
            longest = second;
            shorter = first;
        }

        for (int i = 0; i < min; i++) {
            if (map.containsKey(shorter.charAt(i))){
                if (map.get(shorter.charAt(i)) != longest.charAt(i)){
                    return false;
                }
            } else {
                map.put(shorter.charAt(i), longest.charAt(i));
            }
        }

        List<Character> compare = new ArrayList<>();
        for (Character character : map.values()) {

            if (compare.contains(character)){
                return false;
            }
            compare.add(character);
        }

        for (int i = min; i < longest.length(); i++) {
            if (!compare.contains(longest.charAt(i))){
                return false;
            }
        }

        return true;
    }
}
