package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P9_UserLogs {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        while (true) {
            String[] input = console.nextLine().split(" ");
            if (input[0].equals("end")) {
                break;
            }
            String[] ip = input[0].split("=");
            String[] name = input[2].split("=");

            if (!map.containsKey(name[1])) {
                map.put(name[1], new LinkedHashMap<>());
                map.get(name[1]).put(ip[1], 1);
            } else {
                if (!map.get(name[1]).containsKey(ip[1])) {
                    map.get(name[1]).put(ip[1], 1);
                } else {
                    int oldValue = map.get(name[1]).get(ip[1]);
                    map.get(name[1]).put(ip[1], oldValue + 1);
                }
            }
        }

        for (String name : map.keySet()) {
            System.out.printf("%s: %n" ,name);
            LinkedHashMap<String, Integer> ips = map.get(name);
            String print = "";
            for (Map.Entry<String, Integer> entry : ips.entrySet()) {
                print += String.format("%s => %d, ", entry.getKey(), entry.getValue());
            }
            print = print.substring(0, print.length() - 2) + ".";
            System.out.println(print);
        }
    }
}
