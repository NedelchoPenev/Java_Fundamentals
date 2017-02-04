package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P6_AMinerTask {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        while (true){
            String odd = console.nextLine();
            if (odd.equals("stop")){
                break;
            }
            int even = Integer.parseInt(console.nextLine());

            if (!map.containsKey(odd)){
                map.put(odd, even);
            } else {
                map.put(odd, map.get(odd) + even);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
