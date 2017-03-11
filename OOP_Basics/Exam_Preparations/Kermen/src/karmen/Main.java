package karmen;

import karmen.items.Toy;
import karmen.persons.Child;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Factory factory = new Factory();

        int countCommands = 1;
        while (true) {
            String input = console.readLine();
            if ("Democracy".equals(input)) {
                System.out.println(factory.democracy());
                break;
            }

            String[] split = input.split("\\(|\\)");
            String command = split[0];

            switch (command) {
                case "YoungCouple":
                    String[] salaries = split[1].split(",");
                    double salary1 = Double.parseDouble(salaries[0]);
                    double salary2 = Double.parseDouble(salaries[1]);
                    double tv = Double.parseDouble(split[3]);
                    double fridge = Double.parseDouble(split[5]);
                    double laptop = Double.parseDouble(split[7]);
                    factory.youngCouple(salary1, salary2, tv, fridge, laptop);
                    break;
                case "YoungCoupleWithChildren":
                    String[] salariesYC = split[1].split(", ");
                    double salary1YC = Double.parseDouble(salariesYC[0]);
                    double salary2YC = Double.parseDouble(salariesYC[1]);
                    double tvYC = Double.parseDouble(split[3]);
                    double fridgeYC = Double.parseDouble(split[5]);
                    double laptopYC = Double.parseDouble(split[7]);
                    List<Child> children = getChildren(split);
                    factory.youngCoupleWithChildren(
                            salary1YC, salary2YC, tvYC, fridgeYC, laptopYC, children);
                    break;
                case "AloneYoung":
                    double salary = Double.parseDouble(split[1]);
                    double laptopAY = Double.parseDouble(split[3]);
                    factory.aloneYoung(salary, laptopAY);
                    break;
                case "OldCouple":
                    String[] pensions = split[1].split(",");
                    double pension1 = Double.parseDouble(pensions[0]);
                    double pension2 = Double.parseDouble(pensions[1]);
                    double tvOP = Double.parseDouble(split[3]);
                    double fridgeOP = Double.parseDouble(split[5]);
                    double stoveOP = Double.parseDouble(split[7]);
                    factory.oldCouple(pension1, pension2, tvOP, fridgeOP, stoveOP);
                    break;
                case "AloneOld":
                    double pension = Double.parseDouble(split[1]);
                    factory.aloneOld(pension);
                    break;
                case "EVN":
                    System.out.println(factory.evn());
                    break;
            }


            if (countCommands % 3 == 0) {
                factory.paySalaries();
            } if (input.equals("EVN bill")) {
                factory.evnBill();
            }

            countCommands++;
        }
    }

    private static List<Child> getChildren(String[] split) {
        List<Child> children = new ArrayList<>();
        for (int i = 9; i < split.length; i += 2) {
            List<Toy> toys = new ArrayList<>();
            String[] toysCost = split[i].split(", ");
            double foodCost = Double.parseDouble(toysCost[0]);
            for (int j = 1; j < toysCost.length; j++) {
                toys.add(new Toy(Double.parseDouble(toysCost[j])));
            }
            children.add(new Child(foodCost, toys));
        }
        return children;
    }
}
