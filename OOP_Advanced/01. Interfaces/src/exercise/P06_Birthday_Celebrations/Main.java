package exercise.P06_Birthday_Celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> entities = new ArrayList<>();
        while (true) {
            String input = console.readLine();
            if ("End".equals(input)) {
                break;
            }

            String[] split = input.split("\\s+");
            String type = split[0];

            switch (type){
                case "Citizen":
                    entities.add(new Human(split[1], Integer.parseInt(split[2]), split[3], split[4]));
                    break;
                case "Pet":
                    entities.add(new Pet(split[1], split[2]));
                    break;
            }
        }
        String birthday = console.readLine();

        entities.stream()
                .filter(i -> i.getBirthday().endsWith(birthday))
                .forEach(i -> System.out.println(i.getBirthday()));
    }
}
