package lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p4_CountSameValuesinArray {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split(" ");

        HashMap<String, Integer> occurrence = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            String number = input[i];

            if (!occurrence.containsKey(number)){
                occurrence.put(number, 1);
            } else {
                int oldValue = occurrence.get(number);
                occurrence.put(number, oldValue + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : occurrence.entrySet()) {
            System.out.printf("%s - %d times%n", entry.getKey(), entry.getValue());
        }
    }
}

