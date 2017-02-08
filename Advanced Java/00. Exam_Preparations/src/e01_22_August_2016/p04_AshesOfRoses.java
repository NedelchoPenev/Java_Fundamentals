package e01_22_August_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_AshesOfRoses {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^Grow <([A-Z][a-z]*)> <([A-Za-z0-9]+)> ([\\d]+)$";
        Pattern pattern = Pattern.compile(regex);

        TreeMap<String, TreeMap<String,Long>> regions = new TreeMap<>();
        while (true) {
            String input = console.readLine();
            if ("Icarus, Ignite!".equals(input)) {
                break;
            }

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String region = matcher.group(1);
                String color = matcher.group(2);
                long quantity = Long.parseLong(matcher.group(3));

                if (!regions.containsKey(region)){
                    regions.put(region, new TreeMap<>());
                    regions.get(region).put(color, quantity);
                } else {
                    if (!regions.get(region).containsKey(color)){
                        regions.get(region).put(color, quantity);
                    } else {
                        long oldQuantity = regions.get(region).get(color);
                        regions.get(region).put(color, oldQuantity + quantity);
                    }
                }
            }
        }

        regions.entrySet().stream().sorted((r1, r2) -> {
            Long firstSum = r1.getValue().values().stream().mapToLong(Number::longValue).sum();
            Long secondSum = r2.getValue().values().stream().mapToLong(Number::longValue).sum();
            return secondSum.compareTo(firstSum);
        }).forEach(r -> {
            System.out.println(r.getKey());
            TreeMap<String, Long> colors = regions.get(r.getKey());
            colors.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(c -> System.out
                    .printf("*--%s | %d%n", c.getKey(), c.getValue()));
        });
    }
}
