package exercise.p14_Refactoring;

import exercise.p14_Refactoring.core.Engine;
import exercise.p14_Refactoring.core.WeaponCreator;
import exercise.p14_Refactoring.core.WeaponData;
import exercise.p14_Refactoring.io.InputReader;
import exercise.p14_Refactoring.io.OutputWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        WeaponCreator weaponCreator = new WeaponCreator();
        WeaponData weaponsData = new WeaponData();

        Engine engine = new Engine(weaponsData, weaponCreator, reader, writer);
        engine.run();
    }
}
