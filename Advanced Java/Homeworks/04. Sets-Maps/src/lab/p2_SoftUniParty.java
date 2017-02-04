package lab;

import java.util.HashSet;
import java.util.Scanner;

public class p2_SoftUniParty {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);

        HashSet<String> quest = new HashSet<>();
        while (true) {
            String input = console.nextLine();
            if (input.equals("PARTY")) {
                break;
            }

            quest.add(input);
        }

        while (true) {
            String input = console.nextLine();
            if (input.equals("END")) {
                break;
            }

            quest.remove(input);
        }

        System.out.println(quest.size());
        quest.stream().sorted().forEach(System.out::println);
    }
}
