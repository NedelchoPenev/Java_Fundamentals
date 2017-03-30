package exercise.p09_Traffic_Lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] lights = console.readLine().split("\\s+");

        TrafficLight[] trafficLight = new TrafficLight[lights.length];

        for (int i = 0; i < trafficLight.length; i++) {
            trafficLight[i] = new TrafficLight(Lights.valueOf(lights[i]));
        }

        int lines = Integer.parseInt(console.readLine());
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < trafficLight.length; j++) {
                trafficLight[j].update();
                System.out.print(trafficLight[j] + " ");
            }
            System.out.println();
        }
    }
}
