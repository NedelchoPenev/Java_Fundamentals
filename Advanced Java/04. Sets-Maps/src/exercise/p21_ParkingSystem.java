package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class p21_ParkingSystem {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] size = console.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        HashMap<Integer, HashSet<Integer>> parkedSpots = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            parkedSpots.put(i, new HashSet<>());
        }

        while (true) {
            String[] input = console.nextLine().split("\\s+");
            if ("stop".equals(input[0])) {
                break;
            }

            int entryRow = Integer.parseInt(input[0]);
            int desiredRow = Integer.parseInt(input[1]);
            int desiredCol = Integer.parseInt(input[2]);

            if (parkedSpots.get(desiredRow).size() == cols - 1){
                System.out.printf("Row %d full%n", desiredRow);
            }

            int distanceTraveled = Math.abs(entryRow - desiredRow) + 1;

            if (parkedSpots.get(desiredRow).contains(desiredCol)){
                for (int i = 0; i < cols  - 1; i++) {
                    if (!parkedSpots.get(desiredRow).contains(desiredCol - 1 - i) && desiredCol - 1 - i > 0){
                        parkedSpots.get(desiredRow).add((desiredCol - 1) - i);
                        distanceTraveled = distanceTraveled + (desiredCol - 1) - i;
                        System.out.println(distanceTraveled);
                        break;
                    } else if (!parkedSpots.get(desiredRow).contains(desiredCol + 1 + i) && desiredCol + 1 + i < cols){
                        parkedSpots.get(desiredRow).add((desiredCol + 1) + i);
                        distanceTraveled = distanceTraveled + (desiredCol + 1) + i;
                        System.out.println(distanceTraveled);
                        break;
                    }
                }
            } else {
                parkedSpots.get(desiredRow).add(desiredCol);
                distanceTraveled = distanceTraveled + desiredCol;
                System.out.println(distanceTraveled);
            }
        }
    }
}
