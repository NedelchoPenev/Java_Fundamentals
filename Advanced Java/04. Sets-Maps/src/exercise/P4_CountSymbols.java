package exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P4_CountSymbols {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        TreeMap<Character, Integer> map = new TreeMap<>();

        String input = console.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i))){
                map.put(input.charAt(i), 1);
            } else {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
