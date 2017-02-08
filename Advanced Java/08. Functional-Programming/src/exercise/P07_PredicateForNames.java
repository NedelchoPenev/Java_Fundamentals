package exercise;

import java.util.Arrays;
        import java.util.Scanner;
        import java.util.function.Predicate;

public class P07_PredicateForNames {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        int num = Integer.parseInt(console.nextLine());
        String[] names = console.nextLine().split("\\s+");

        Predicate<String> predicate = x -> x.length() <= num;
        Arrays.stream(names).filter(predicate).forEach(System.out::println);
    }
}
