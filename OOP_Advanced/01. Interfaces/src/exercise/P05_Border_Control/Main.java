package exercise.P05_Border_Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Indificable> entities = new ArrayList<>();
        while (true) {
            String input = console.readLine();
            if ("End".equals(input)) {
                break;
            }

            String[] split = input.split("\\s+");

            if (split.length == 2){
                entities.add(new Robot(split[0], split[1]));
            } else {
                entities.add(new Human(split[0], Integer.parseInt(split[1]), split[2]));
            }
        }
        String detained = console.readLine();

        entities.stream().filter(i -> i.getId().endsWith(detained)).forEach(System.out::println);
    }
}
