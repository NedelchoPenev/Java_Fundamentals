package exercise.p14_Refactoring.core;

import exercise.p14_Refactoring.annotations.ClassInfo;
import exercise.p14_Refactoring.enums.Gems;
import exercise.p14_Refactoring.interfaces.Item;
import exercise.p14_Refactoring.interfaces.Runnable;
import exercise.p14_Refactoring.io.InputReader;
import exercise.p14_Refactoring.io.OutputWriter;
import exercise.p14_Refactoring.models.Weapon;

import java.io.IOException;
import java.util.Arrays;

public class Engine implements Runnable {
    private WeaponData weaponsData;
    private WeaponCreator weaponCreator;
    private InputReader reader;
    private OutputWriter writer;
    private boolean isRunning;

    public Engine(WeaponData weaponsData, WeaponCreator weaponCreator, InputReader reader, OutputWriter writer) {
        this.weaponsData = weaponsData;
        this.weaponCreator = weaponCreator;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() throws IOException {

        this.isRunning = true;

        while (isRunning) {
            String input = reader.read();
            String[] tokens = input.split(";");
            String commandType = tokens[0];
            switch (commandType) {
                case "Create":
                    this.createWeapon(tokens);
                    break;
                case "Add":
                    this.addGemToWeapon(tokens);
                    break;
                case "Remove":
                    this.removeGemFromWeapon(tokens);
                    break;
                case "Print":
                    this.printWeapon(tokens);
                    break;
                case "Compare":
                    this.printGreaterWeapon(tokens);
                    break;
                case "Author":
                case "Revision":
                case "Description":
                case "Reviewers":
                    this.printAnnotation(tokens);
                    break;
                case "END":
                    this.isRunning = false;
                    break;
                default:
                    writer.writeLine("Invalid command.");
                    break;
            }
        }
    }

    private void printWeapon(String[] tokens) {
        Item weapon = this.weaponsData.getItem(tokens[1]);
        System.out.println(weapon);
    }

    private void printAnnotation(String[] tokens) {
        Class<Weapon> cl = Weapon.class;
        ClassInfo weaponClassInfo = cl.getAnnotation(ClassInfo.class);
        switch (tokens[0]) {
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

    private void printGreaterWeapon(String[] tokens) {
        StringBuilder sb = new StringBuilder();
        Item first = weaponsData.getItem(tokens[1]);
        Item second = weaponsData.getItem(tokens[2]);

        if (first.compareTo(second) >= 0) {
            sb.append(first);
            sb.append(String.format(" (Item Level: %.1f)", first.getItemLevel()));
        } else {
            sb.append(second);
            sb.append(String.format(" (Item Level: %.1f)", second.getItemLevel()));
        }

        writer.writeNewLine(sb.toString());
    }

    private void removeGemFromWeapon(String[] tokens) {
        String weaponName = tokens[1];
        Item weapon = weaponsData.getItem(weaponName);

        int socketIndex = Integer.valueOf(tokens[2]);
        weapon.removeGem(socketIndex);
    }

    private void addGemToWeapon(String[] tokens) {
        String weaponName = tokens[1];
        Item weapon = this.weaponsData.getItem(weaponName);

        int socketIndex = Integer.valueOf(tokens[2]);
        Gems gem = Enum.valueOf(Gems.class, tokens[3]);
        weapon.addGem(gem, socketIndex);
    }

    private void createWeapon(String[] tokens) {
        Item weapon = weaponCreator.create(tokens);
        weaponsData.addItem(weapon.getName(), weapon);
    }
}
