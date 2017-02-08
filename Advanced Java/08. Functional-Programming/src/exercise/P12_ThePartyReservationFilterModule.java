package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P12_ThePartyReservationFilterModule {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        List<String> names = Arrays.stream(console.nextLine().split(" "))
                .collect(Collectors.toList());
        HashMap<String, Predicate<String>> map = new HashMap<>();

        while (true) {
            String[] input = console.nextLine().split(";");
            if (input[0].equals("Print")) {
                break;
            }

            String command = input[0];
            String checkTest = input[1];
            String var = input[2];

            Predicate<String> currentPredicate = predicate(checkTest, var);

            switch (command){
                case "Add filter":
                    map.put(checkTest + var, currentPredicate);
                    break;
                case "Remove filter":
                    map.remove(checkTest + var);
                    break;
            }
        }
        for (String name : names) {
            boolean toAdd = true;
            for (Predicate<String> predicate : map.values()) {
                if (predicate.test(name)){
                    toAdd = false;
                }
            }
            if (toAdd){
                System.out.print(name + " ");
            }
        }
    }

    private static Predicate<String> predicate(String checkTest, String var) {
        switch (checkTest) {
            case "Starts with":
                return n -> n.startsWith(var);

            case "Ends with":
                return n -> n.endsWith(var);

            case "Length":
                int length = Integer.parseInt(var);
                return n -> n.length() == length;

            case "Contains":
                return n -> n.contains(var);

            default:
                return null;
        }
    }
}
