package exercise.P03_Animal_Farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String name = console.readLine();
        int age = Integer.parseInt(console.readLine());

        try {
            Chicken chicken = new Chicken(name, age);
            if (chicken.productPerDay() == 0.75) {
                System.out.printf("Chicken %s (age %d) can produce %s eggs per day.",
                        chicken.getName(), chicken.getAge(), chicken.productPerDay());
            } else {
                System.out.printf("Chicken %s (age %d) can produce %.0f eggs per day.",
                        chicken.getName(), chicken.getAge(), chicken.productPerDay());
            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
