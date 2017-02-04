package exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P2_SetsOfElements {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int first = console.nextInt();
        int second = console.nextInt();
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();

        console.nextLine();
        for (int i = 0; i < first; i++) {
            firstSet.add(console.nextLine());
        }
        for (int i = 0; i < second; i++) {
            secondSet.add(console.nextLine());
        }

        firstSet.retainAll(secondSet);

        firstSet.stream().forEach(pr -> System.out.printf("%s ", pr));
    }
}
