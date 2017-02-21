package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P10_GroupByGroup {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }

            String name = input[0] + " " + input[1];
            int group = Integer.parseInt(input[2]);
            Person person = new Person(group, name);
            people.add(person);
        }

        people.stream()
                .collect(Collectors.groupingBy(person -> person.getGroup()))
                .forEach((group, name) -> {
                    System.out.printf("%d - ", group);
                    StringBuilder sb = new StringBuilder();
                    name.stream().forEach(p -> sb.append(String.format("%s, ", p.getName())));
                    sb.setLength(sb.length() - 2);
                    System.out.println(sb);
                });
    }
}

class Person{

    private String name;
    private int group;

    public Person(int group, String name) {

        this.group = group;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}