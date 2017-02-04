package exercise;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class P14_DragonArmy {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, LinkedList<Integer>>> map = new LinkedHashMap<>();
        int lines = Integer.parseInt(console.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] input = console.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            int[] arr = values(input);
            int damage = arr[0];
            int health = arr[1];
            int armor = arr[2];

            if (!map.containsKey(type)){
                map.put(type, new TreeMap<>());
                if (!map.get(type).containsKey(name)){
                    map.get(type).put(name, new LinkedList<>());
                    map.get(type).get(name).add(damage);
                    map.get(type).get(name).add(health);
                    map.get(type).get(name).add(armor);
                } else {
                    map.get(type).get(name).clear();
                    map.get(type).get(name).add(damage);
                    map.get(type).get(name).add(health);
                    map.get(type).get(name).add(armor);
                }

            } else {
                if (!map.get(type).containsKey(name)){
                    map.get(type).put(name, new LinkedList<>());
                    map.get(type).get(name).add(damage);
                    map.get(type).get(name).add(health);
                    map.get(type).get(name).add(armor);
                } else {
                    map.get(type).get(name).clear();
                    map.get(type).get(name).add(damage);
                    map.get(type).get(name).add(health);
                    map.get(type).get(name).add(armor);
                }
            }
        }

        for (String type : map.keySet()) {
            TreeMap<String, LinkedList<Integer>> dragons = map.get(type);
            double damage = 0;
            double health = 0;
            double armor = 0;
            double divider = dragons.size();
            for (String dragon : dragons.keySet()) {
                LinkedList<Integer> values = dragons.get(dragon);
                damage += values.get(0);
                health += values.get(1);
                armor += values.get(2);
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type,
                    damage / divider, health / divider, armor / divider);
            for (String dragon : dragons.keySet()) {
                LinkedList<Integer> values = dragons.get(dragon);
                int damageD = values.get(0);
                int healthD = values.get(1);
                int armorD = values.get(2);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragon, damageD, healthD, armorD);
            }
        }
    }

    private static int[] values (String[] str){
        int[] values = new int[3];
        if (str[2].equals("null")){
            values[0] = 45;
        } else {
            values[0] = Integer.parseInt(str[2]);
        }
        if (str[3].equals("null")){
            values[1] = 250;
        } else {
            values[1] = Integer.parseInt(str[3]);
        }
        if (str[4].equals("null")){
            values[2] = 10;
        } else {
            values[2] = Integer.parseInt(str[4]);
        }
        return values;
    }
}
