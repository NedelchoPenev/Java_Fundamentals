package exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p11_ActivityTrackerTests {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        int lines = Integer.parseInt(console.nextLine());

        TreeMap<Integer, TreeMap<String, Integer>> monthsActivities = new TreeMap<>();
        for (int i = 0; i < lines; i++) {
            String[] input = console.nextLine().split("\\s+");
            String[] date = input[0].split("/");
            int month = Integer.parseInt(date[1]);
            String name = input[1];
            int steps = Integer.parseInt(input[2]);

            if (!monthsActivities.containsKey(month)){
                monthsActivities.put(month, new TreeMap<>());
                monthsActivities.get(month).put(name, steps);
            } else {
                if (!monthsActivities.get(month).containsKey(name)){
                    monthsActivities.get(month).put(name, steps);
                } else {
                    int oldValue = monthsActivities.get(month).get(name);
                    monthsActivities.get(month).put(name, oldValue + steps);
                }
            }
        }

        for (Integer month : monthsActivities.keySet()) {
            System.out.printf("%d: ", month);

            TreeMap<String, Integer> namesSteps = monthsActivities.get(month);
            String output = "";
            for (Map.Entry<String, Integer> entry : namesSteps.entrySet()) {
                output += String.format("%s(%d), ", entry.getKey(), entry.getValue());
            }

            System.out.println(output.substring(0, output.length() - 2));
        }
    }
}
