package exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class P01_ConsumerPrint {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        Consumer<String> consumer = x -> System.out.println(x);
        String[] names = console.nextLine().split(" ");

        for (String name : names) {
            consumer.accept(name);
        }
    }
}
