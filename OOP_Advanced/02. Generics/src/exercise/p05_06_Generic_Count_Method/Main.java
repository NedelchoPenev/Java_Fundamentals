package exercise.p05_06_Generic_Count_Method;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        int lines = Integer.parseInt(console.nextLine());

        List<Box<Double>> list = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            list.add(new Box<Double>(Double.parseDouble(console.nextLine())));
        }

        double comparingElement = Double.parseDouble(console.nextLine());
        System.out.println(countGreater(list, new Box<>(comparingElement)));
    }

    private static <T extends Comparable<T>> long countGreater(List<T> list, T comparingElement){
        return list.stream().filter(e -> e.compareTo(comparingElement) > 0).count();
    }
}
