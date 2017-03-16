package exercise.P10_MooD_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] inputTokens = console.readLine().split("[\\s\\|]+");
        String name = inputTokens[0];
        String type = inputTokens[1];
        String specialPoints = inputTokens[2];
        String level = inputTokens[3];

        switch (type.toLowerCase()) {
            case "demon":
                GameObject<Integer> demon = new Demon<>(name, Integer.valueOf(level), Double.valueOf
                        (specialPoints));
                demon.setHashedPassword(demon.getUsername().length() * 217);
                System.out.println(demon.toString());
                break;
            case "archangel":
                GameObject<String> archangel = new Archangel<>(name, Integer.valueOf(level), Integer.valueOf
                        (specialPoints));
                StringBuilder stringBuilder = new StringBuilder(archangel.getUsername());
                stringBuilder = stringBuilder.reverse();
                archangel.setHashedPassword(stringBuilder.toString() + (archangel.getUsername().length() * 21));
                System.out.println(archangel.toString());
                break;
        }
    }
}
