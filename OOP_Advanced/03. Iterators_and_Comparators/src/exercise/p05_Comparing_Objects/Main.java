package exercise.p05_Comparing_Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("END".equals(input[0])) {
                break;
            }

            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String town = input[2];

            people.add(new Person(name, age, town));
        }

        int index = Integer.parseInt(console.readLine());

        Person person = people.get(index - 1);

        long equalPeople =  people.stream().filter(p -> p.compareTo(person) == 0).count();
        int notEqualPeople = (int) (people.size() - equalPeople);
        if (equalPeople > 1) {
            System.out.println(equalPeople + " " + notEqualPeople + " " + people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
