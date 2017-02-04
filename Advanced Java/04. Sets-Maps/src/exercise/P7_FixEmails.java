package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P7_FixEmails {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        while (true) {
            String name = console.nextLine();
            if (name.equals("stop")) {
                break;
            }
            String email = console.nextLine();

            if (!email.toLowerCase().endsWith(".us") && !email.toLowerCase().endsWith(".uk")) {
                map.put(name, email);
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
