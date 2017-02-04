package exercise;

import java.util.*;

public class P11_LogsAggregator {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int count = console.nextInt();
        console.nextLine();
        TreeMap<String, Integer> nameDuration = new TreeMap<>();
        TreeMap<String, TreeSet<String>> nameIPs = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String[] input = console.nextLine().split(" ");
            int num = Integer.parseInt(input[2]);
            if (nameDuration.containsKey(input[1])) {
                nameDuration.put(input[1], nameDuration.get(input[1]) + num);
            } else {
                nameDuration.put(input[1], num);
            }

            TreeSet<String> ips = nameIPs.get(input[1]);
            if (ips == null) {
                ips = new TreeSet<>();
            }
            ips.add(input[0]);
            nameIPs.put(input[1], ips);
        }
        for (Map.Entry<String, Integer> name : nameDuration.entrySet()) {
            TreeSet<String> ips = nameIPs.get(name.getKey());
            System.out.println(name.getKey() + ": " + name.getValue() + " " + ips);
        }
    }
}
