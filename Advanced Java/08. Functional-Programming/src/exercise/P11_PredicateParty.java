package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P11_PredicateParty {

    private static List<String> names;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        names = new ArrayList<>(Arrays.asList(console.nextLine().split("\\s+")));
        Consumer<List<String>> consumer =
                n -> System.out.printf(String.join(", ", n) + " are going to the party!");

        while (true) {
            String[] input = console.nextLine().split("\\s+");
            if (input[0].equals("Party!")) {
                break;
            }

            String command = input[0];
            String checkTest = input[1];
            String var = input[2];

            Predicate<String> predicateToUse = predicate(checkTest, var);

            switch (command) {
                case "Remove":
                    names.removeIf(predicateToUse);
                    break;
                case "Double":
                    doubleIf(predicateToUse);
                    break;
            }
        }

        if (names.size() > 0) {
            consumer.accept(names);
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static void doubleIf(Predicate<String> predicateToUse) {
        for (int i = 0; i < names.size(); i++) {
            if (predicateToUse.test(names.get(i))) {
                names.add(i, names.get(i));
                i++;
            }
        }
    }

    private static Predicate<String> predicate(String checkTest, String var) {
        switch (checkTest) {
            case "StartsWith":
                return n -> n.startsWith(var);

            case "EndsWith":
                return n -> n.endsWith(var);

            case "Length":
                int length = Integer.parseInt(var);
                return n -> n.length() == length;

            default:
                return null;
        }
    }
}
