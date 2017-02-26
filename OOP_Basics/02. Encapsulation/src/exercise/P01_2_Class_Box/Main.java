package exercise.P01_2_Class_Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(console.readLine());
        double width = Double.parseDouble(console.readLine());
        double height = Double.parseDouble(console.readLine());

        try {
            Box box = new Box(length, width, height);

            System.out.printf("Surface Area - %.2f%n", box.surfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.lateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.volume());
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
