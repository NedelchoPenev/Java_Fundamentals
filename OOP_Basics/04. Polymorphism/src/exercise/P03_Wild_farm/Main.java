package exercise.P03_Wild_farm;

import exercise.P03_Wild_farm.animals.*;
import exercise.P03_Wild_farm.foods.Food;
import exercise.P03_Wild_farm.foods.Meat;
import exercise.P03_Wild_farm.foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] animalArgs = console.readLine().split("\\s+");
            if ("End".equals(animalArgs[0])) {
                break;
            }

            String animalType = animalArgs[0];
            String name = animalArgs[1];
            double weight = Double.parseDouble(animalArgs[2]);
            String region = animalArgs[3];

            String[] foodArgs = console.readLine().split("\\s+");
            String foodType = foodArgs[0];
            int quantity = Integer.parseInt(foodArgs[1]);

            Food food = null;
            if (foodType.equals("Vegetable")){
                food = new Vegetable(quantity);
            } else {
                food = new Meat(quantity);
            }

            Animal animal = null;
            switch (animalType){
                case "Cat":
                    String breed = animalArgs[4];
                    animal = new Cat(animalType, name, weight, region, breed);
                    break;
                case "Tiger":
                    animal = new Tiger(animalType, name, weight, region);
                    break;
                case "Mouse":
                    animal = new Mouse(animalType, name, weight, region);
                    break;
                default:
                    animal = new Zebra(animalType, name, weight, region);
                    break;
            }
            System.out.println(animal.makeSound());
            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(animal);
        }
    }
}
