package lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p5_AcademyGraduation {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        int lines = Integer.parseInt(console.nextLine());

        TreeMap<String, Double> students = new TreeMap<>();
        String nameOfStudent = "";
        for (int i = 0; i < lines * 2; i++) {
            String[] input = console.nextLine().split(" ");
            if (i % 2 == 0){
                nameOfStudent = input[0];
                students.put(nameOfStudent, 0d);
            } else {
                double average = 0d;
                for (int j = 0; j < input.length; j++) {
                    double grades = Double.parseDouble(input[j]);
                    average += grades;
                }
                students.put(nameOfStudent, average / input.length);
            }
        }

        for (Map.Entry<String, Double> entry : students.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }
}
