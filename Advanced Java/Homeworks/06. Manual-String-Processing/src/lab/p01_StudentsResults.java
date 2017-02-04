package lab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class p01_StudentsResults {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, ArrayList<Double>> grades = new TreeMap<>();

        int lines = Integer.parseInt(console.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] split = console.nextLine().split(" - ");
            String name = split[0];
            String[] gradesPerStudent = split[1].split(", ");

            grades.put(name, new ArrayList<>());

            for (int j = 0; j < gradesPerStudent.length; j++) {
                grades.get(name).add(Double.parseDouble(gradesPerStudent[j]));
            }
        }

        if (lines != 0) {
            System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|",
                    "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
            for (String name : grades.keySet()) {
                double average = grades.get(name).stream().mapToDouble(a -> a).average().getAsDouble();
                System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                        name, grades.get(name).get(0), grades.get(name).get(1), grades.get(name).get(2), average)
                        .replace(".", ","));
            }
        }
    }
}
