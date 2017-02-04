package exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p15_PoisonousPlants {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        int numPlants = Integer.parseInt(console.nextLine());
        int[] plants = new int[numPlants];

        for (int i = 0; i < numPlants; i++) {
            plants[i] = console.nextInt();
        }

        ArrayDeque<Integer> proximityStack = new ArrayDeque<>();
        proximityStack.push(0);
        int[] days = new int[plants.length];

        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;
            while(proximityStack.size() > 0 && plants[proximityStack.peek()] >= plants[i]){
                maxDays = Integer.max(days[proximityStack.pop()], maxDays);
            }

            if (proximityStack.size() > 0){
                days[i] = maxDays + 1;
            }

            proximityStack.push(i);
        }

        Arrays.sort(days);
        System.out.println(days[days.length - 1]);
    }
}
