package exercise.p03_04_Generic_Swap_Method;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner console =  new Scanner(System.in);

        List<Box> elements = new ArrayList<>();
        int lines = Integer.parseInt(console.nextLine());

        for (int i = 0; i < lines; i++) {
            int input = Integer.parseInt(console.nextLine());
            Box<Integer> box = new Box<>(input);
            elements.add(box);
        }

        int firstIndex = console.nextInt();
        int secondIndex = console.nextInt();
        Box.swap(elements, firstIndex, secondIndex);

        elements.forEach(System.out::println);

    }
}
