package lab.P04_FirstAndReserveTeam;

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
            try {
                people.add(new Person(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3])));
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        Team team = new Team("Minior");
        for (Person person : people) {
            team.addPlayer(person);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
