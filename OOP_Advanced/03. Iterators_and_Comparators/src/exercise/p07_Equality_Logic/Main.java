package exercise.p07_Equality_Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> treePerson = new TreeSet<>();
        HashSet<Person> hashPerson = new HashSet<>();

        int lines = Integer.parseInt(console.readLine());
        for (int i = 0; i < lines; i++) {
            String[] input = console.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            treePerson.add(new Person(name, age));
            hashPerson.add(new Person(name, age));
        }

        System.out.println(treePerson.size());
        System.out.println(hashPerson.size());
    }
}
