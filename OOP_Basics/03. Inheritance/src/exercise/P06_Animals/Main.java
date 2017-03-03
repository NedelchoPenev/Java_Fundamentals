package exercise.P06_Animals;

import exercise.P06_Animals.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = console.readLine();
            if ("Beast!".equals(input)) {
                break;
            }

            String[] animalArgs = console.readLine().split("\\s+");
            String name = animalArgs[0];
            int age = Integer.parseInt(animalArgs[1]);
            String gender = animalArgs[2];

            Animal animal = null;
            try {
                switch (input) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age, gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age, gender);
                        break;
                    default:
                        System.out.println("Invalid input!");
                }

                if (animal != null) {
                    System.out.println(animal);
                    System.out.println(animal.soundProduce());
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
