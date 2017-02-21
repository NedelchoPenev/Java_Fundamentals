package e02_19_July_2015;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class P04_PopulationCounter {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> map = new LinkedHashMap<>();
        LinkedHashMap<String, Long> totalPopulation = new LinkedHashMap<>();

        while (true) {
            String[] input = console.nextLine().split("\\|");
            if (input[0].equals("report")){
                break;
            }
            String country = input[1];
            String city = input[0];
            long population = Long.parseLong(input[2]);

            if (!map.containsKey(country)){
                map.put(country, new LinkedHashMap<>());
                map.get(country).put(city, population);
                totalPopulation.put(country, population);
            } else {
                totalPopulation.put(country, totalPopulation.get(country) + population);
                if (!map.get(country).containsKey(city)){
                    map.get(country).put(city, population);
                } else {
                    long oldValue = map.get(country).get(city);
                    map.get(country).put(city, oldValue + population);
                }
            }
        }

        LinkedList<String> countries = new LinkedList<>();
        totalPopulation.entrySet().stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .forEach(c -> countries.add(c.getKey()));

        for (String country : countries) {
            System.out.printf("%s (total population: %d)%n", country, totalPopulation.get(country));
            LinkedHashMap<String, Long> cities = map.get(country);
            cities.entrySet().stream()
                    .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                    .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
        }
    }
}
