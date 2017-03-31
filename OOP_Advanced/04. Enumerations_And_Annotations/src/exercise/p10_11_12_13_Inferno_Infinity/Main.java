package exercise.p10_11_12_13_Inferno_Infinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Weapon> weapons = new TreeMap<>();
        while (true) {
            String[] input = console.readLine().split(";");
            if ("END".equals(input[0])) {
                break;
            }

            String command = input[0];

            switch (command) {
                case "Create":
                    String weaponType = input[1];
                    String weaponName = input[2];
                    WeaponsType weaponsType = WeaponsType.valueOf(weaponType);
                    weapons.put(weaponName, new Weapon(weaponsType, weaponName));
                    break;
                case "Add":
                    String weaponNameAdd = input[1];
                    int indexAdd = Integer.parseInt(input[2]);
                    String gemType = input[3];
                    Gems gem = Gems.valueOf(gemType);
                    weapons.get(weaponNameAdd).addGem(indexAdd, gem);
                    break;
                case "Remove":
                    String weaponNameRemove = input[1];
                    int indexRemove = Integer.parseInt(input[2]);
                    weapons.get(weaponNameRemove).removeGem(indexRemove);
                    break;
                case "Print":
                    String weaponNamePrint = input[1];
                    System.out.println(weapons.get(weaponNamePrint));
                    break;
                case "Compare":
                    String weapon1Name = input[1];
                    String weapon2Name = input[2];
                    Weapon weapon1 = weapons.get(weapon1Name);
                    Weapon weapon2 = weapons.get(weapon2Name);
                    Weapon winner = weapon1.compareTo(weapon2) > 0 ? weapon1 : weapon2;
                    System.out.printf("%s (Item Level: %.1f)%n", winner, winner.itemLevel());
                    break;
                case "Author":
                case "Revision":
                case "Description":
                case "Reviewers":
                    printAnnotation(input);
                    break;
            }
        }
    }

    private static void printAnnotation(String[] input) {
        Class<Weapon> cl = Weapon.class;
        ClassInfo weaponClassInfo = cl.getAnnotation(ClassInfo.class);
        switch (input[0]) {
            case "Author":
                System.out.println("Author: " + weaponClassInfo.author());
                break;
            case "Revision":
                System.out.println("Revision: " + weaponClassInfo.revision());
                break;
            case "Description":
                System.out.println("Class description: " + weaponClassInfo.description());
                break;
            case "Reviewers":
                String reviewers = String.join(", ", Arrays.asList(weaponClassInfo.reviewers()));
                System.out.println("Reviewers: " + reviewers);
                break;
        }
    }
}
