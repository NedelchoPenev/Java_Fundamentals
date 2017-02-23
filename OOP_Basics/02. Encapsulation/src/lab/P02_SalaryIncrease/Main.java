package lab.P02_SalaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] split = console.readLine().split("\\s+");
            people.add(new Person(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3])));
        }

        int bonus = Integer.parseInt(console.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
