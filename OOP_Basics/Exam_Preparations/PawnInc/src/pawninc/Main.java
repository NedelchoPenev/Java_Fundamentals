package pawninc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        AnimalCenterManager animalCenterManager = new AnimalCenterManager();
        while (true) {
            String input = console.readLine();
            if ("Paw Paw Pawah".equals(input)) {
                break;
            }

            String[] commandArgs = input.split(" \\| ");
            String command = commandArgs[0];

            switch (command){
                case "RegisterCleansingCenter":
                    animalCenterManager.registerCleansingCenter(commandArgs[1]);
                    break;
                case "RegisterAdoptionCenter":
                    animalCenterManager.registerAdoptionCenter(commandArgs[1]);
                    break;
                case "RegisterCastrationCenter":
                    animalCenterManager.registerCastrationCenter(commandArgs[1]);
                    break;
                case "RegisterDog":
                    String dogName = commandArgs[1];
                    int dogAge = Integer.parseInt(commandArgs[2]);
                    int dogLearnedCommand = Integer.parseInt(commandArgs[3]);
                    String dogAdoptedCenter = commandArgs[4];
                    animalCenterManager.registerDog(dogName, dogAge, dogLearnedCommand, dogAdoptedCenter);
                    break;
                case "RegisterCat":
                    String name = commandArgs[1];
                    int age = Integer.parseInt(commandArgs[2]);
                    int learnedCommand = Integer.parseInt(commandArgs[3]);
                    String adoptedCenter = commandArgs[4];
                    animalCenterManager.registerCat(name, age, learnedCommand, adoptedCenter);
                    break;
                case "SendForCleansing":
                    animalCenterManager.sendForCleansing(commandArgs[1], commandArgs[2]);
                    break;
                case "SendForCastration":
                    animalCenterManager.sendForCastration(commandArgs[1], commandArgs[2]);
                    break;
                case "Cleanse":
                    animalCenterManager.cleanse(commandArgs[1]);
                    break;
                case "Castrate":
                    animalCenterManager.castrate(commandArgs[1]);
                    break;
                case "Adopt":
                    animalCenterManager.adopt(commandArgs[1]);
                    break;
                case "CastrationStatistics":
                    animalCenterManager.printCastrationStatistics();
                    break;
            }
        }

        animalCenterManager.printStatistics();
    }
}
