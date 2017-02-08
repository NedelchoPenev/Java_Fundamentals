package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class P02_KnightsOfHonor {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] names = console.readLine().split("\\s+");
        Consumer<String> consumer = x -> System.out.printf("Sir %s%n", x);

        for (String name : names) {
            consumer.accept(name);
        }
    }
}
