package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class P14_OfficeStuff {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
        int lines = Integer.parseInt(console.readLine());

        for (int i = 0; i < lines; i++) {
            String[] input = console.readLine().split(" - ");

            String company = input[0].replace("|", "");
            int amount = Integer.valueOf(input[1]);
            String product = input[2].replace("|", "");

            if (!map.containsKey(company)) {
                map.put(company, new LinkedHashMap<>());
                if (!map.get(company).containsKey(product)) {
                    map.get(company).put(product, amount);
                }
            } else {
                if (!map.get(company).containsKey(product)) {
                    map.get(company).put(product, amount);
                } else {
                    int oldValue = map.get(company).get(product);
                    map.get(company).put(product,oldValue + amount);
                }
            }
        }

        for (String company : map.keySet()) {
            System.out.printf("%s: ", company);
            LinkedHashMap<String, Integer> products = map.get(company);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> integerEntry : products.entrySet()) {
                sb.append(String.format("%s-%d, ", integerEntry.getKey(), integerEntry.getValue()));
            }
            sb.setLength(sb.length() - 2);
            System.out.println(sb);
        }
    }
}
