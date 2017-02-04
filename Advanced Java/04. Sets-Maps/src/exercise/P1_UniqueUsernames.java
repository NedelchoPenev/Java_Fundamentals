package exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P1_UniqueUsernames {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        LinkedHashSet<String> set = new LinkedHashSet();
        int lines = Integer.parseInt(console.nextLine());

        for (int i = 0; i < lines; i++) {
            set.add(console.nextLine());
        }

        for (String name : set) {
            System.out.println(name);
        }
    }
}
