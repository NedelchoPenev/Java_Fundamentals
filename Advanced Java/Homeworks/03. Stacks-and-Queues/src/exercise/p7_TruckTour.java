package exercise;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class p7_TruckTour {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        Queue<String> queue = new ArrayDeque<>();
        int stations = Integer.parseInt(console.nextLine());

        for (int i = 0; i < stations; i++) {
            queue.add(console.nextLine());
        }

        int startingIndex = 0;
        boolean found = false;
        int gasInTank = 0;
        while (true){
            String startStation = queue.remove();
            queue.add(startStation);
            String[] split = startStation.split(" ");
            int gas = Integer.parseInt(split[0]);
            int distance = Integer.parseInt(split[1]);
            gasInTank = gas;
            int currentStationsCount = 1;

            while (gasInTank >= distance){
                gasInTank -= distance;
                String nextStation = queue.remove();
                queue.add(nextStation);
                split = nextStation.split(" ");
                gasInTank += Integer.parseInt(split[0]);
                distance = Integer.parseInt(split[1]);

                if (startStation.equals(nextStation)){
                    found = true;
                    break;
                }

                currentStationsCount++;
            }

            if (found){
                break;
            }

            startingIndex += currentStationsCount;
        }

        System.out.println(startingIndex);
    }
}

