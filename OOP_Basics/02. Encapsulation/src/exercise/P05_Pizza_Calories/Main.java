package exercise.P05_Pizza_Calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader console;

    public static void main(String[] args) throws IOException {
        try {
            console = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String[] input = console.readLine().split("\\s+");
                if ("END".equals(input[0])) {
                    break;
                }

                String command = input[0];
                if (command.equalsIgnoreCase("Pizza")) {
                    Pizza pizza = makePizza(input);
                    System.out.println(pizza);

                } else if (command.equalsIgnoreCase("Dough")) {
                    Dough dough = makeDough(input);
                    System.out.printf("%.2f%n", dough.calculateDoughCalories());

                } else if (command.equalsIgnoreCase("Topping")) {
                    Topping topping = makeTopping(input);
                    System.out.printf("%.2f%n", topping.calculateToppingCalories());
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Pizza makePizza(String[] input) throws IOException {

        String command = input[0];
        String name = input[1];
        int numToppings = Integer.parseInt(input[2]);
        Pizza pizza = new Pizza(name, numToppings);

        input = console.readLine().split("\\s+");
        String doughType = input[1];
        String technique = input[2];
        double doughWeight = Double.parseDouble(input[3]);

        pizza.setDough(new Dough(doughType, technique, doughWeight));

        for (int i = 0; i < numToppings; i++) {
            input = console.readLine().split("\\s+");
            String toppingType = input[1];
            double toppingWeight = Double.parseDouble(input[2]);

            pizza.addTopping(new Topping(toppingType, toppingWeight));
        }

        return pizza;
    }

    private static Topping makeTopping(String[] input) {
        String type = input[1];
        double weight = Double.parseDouble(input[2]);

        return new Topping(type, weight);
    }

    private static Dough makeDough(String[] input) {
        String type = input[1];
        String technique = input[2];
        double weight = Double.parseDouble(input[3]);

        return new Dough(type, technique, weight);
    }
}
