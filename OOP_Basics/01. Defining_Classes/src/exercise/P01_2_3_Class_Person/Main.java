package exercise.P01_2_3_Class_Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] split = console.readLine().split("\\s+");
            String name = split[0];
            int age = Integer.parseInt(split[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(a -> a.age > 30)
                .sorted(Comparator.comparing(n -> n.name))
                .forEach(System.out::println);
    }
}
