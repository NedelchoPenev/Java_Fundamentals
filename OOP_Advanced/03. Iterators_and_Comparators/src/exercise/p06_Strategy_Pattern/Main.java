package exercise.p06_Strategy_Pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());

        TreeSet<Person> peopleLength = new TreeSet<>(new NameLengthComparator());
        TreeSet<Person> peopleAge = new TreeSet<>(new AgeComparator());

        for (int i = 0; i < lines; i++) {
            String[] input = console.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            peopleLength.add(new Person(name, age));
            peopleAge.add(new Person(name, age));
        }

        peopleLength.forEach(System.out::println);
        peopleAge.forEach(System.out::println);
    }
}
