package exercise.P04_Shopping_Spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));) {

            String[] peopleAndMoney = console.readLine().split(";");
            String[] productsAndCost = console.readLine().split(";");

            Map<String, Person> people = new LinkedHashMap<>();
            Map<String, Product> products = new LinkedHashMap<>();
            for (String param : peopleAndMoney) {
                String[] split = param.replace(";", "").split("=");
                String name = split[0];
                double money = Double.parseDouble(split[1]);
                people.put(name, new Person(name, money));
            }
            for (String param : productsAndCost) {
                String[] split = param.replace(";", "").split("=");
                String name = split[0];
                double cost = Double.parseDouble(split[1]);
                products.put(name, new Product(name, cost));
            }

            while (true) {
                String[] input = console.readLine().split("\\s+");
                if ("END".equals(input[0])) {
                    break;
                }

                String person = input[0];
                String product = input[1];

                people.get(person).buyProduct(products.get(product));
            }

            people.values().forEach(System.out::println);

        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
