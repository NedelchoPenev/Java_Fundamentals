package exercise.P07_Food_Shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Buyer> buyers = new HashMap<>();
        int lines = Integer.parseInt(console.readLine());
        for (int i = 0; i < lines; i++) {
            String[] split = console.readLine().split("\\s+");
            if (split.length == 3){
                buyers.put(split[0], new Rebel(split[0], Integer.parseInt(split[1]), split[2]));
            } else {
                buyers.put(split[0], new Human(split[0], Integer.parseInt(split[1]), split[2], split[3]));
            }
        }

        while (true) {
            String name = console.readLine();
            if ("End".equals(name)) {
                break;
            }

            if (buyers.containsKey(name)){
                buyers.get(name).BuyFood();
            }
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
