package exercise.p10_11_TupleAndThreeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] nameAndAddress = console.readLine().split("\\s+");
        String name = nameAndAddress[0] + " " + nameAndAddress[1];
        String address = nameAndAddress[2];
        String town = nameAndAddress[3];
        Threeuple<String, String, String> addressThreeuple = new Threeuple<>(name, address, town);

        String[] nameAndBeers = console.readLine().split("\\s+");
        String name1 = nameAndBeers[0];
        int beers = Integer.parseInt(nameAndBeers[1]);
        String drunkCondition = nameAndBeers[2];
        boolean isDrunk = drunkCondition.equals("drunk");
        Threeuple<String, Integer, Boolean> beerThreeuple = new Threeuple<>(name1, beers, isDrunk);

        String[] nameAndBank = console.readLine().split("\\s+");
        String name2 = nameAndBank[0];
        double balance = Double.parseDouble(nameAndBank[1]);
        String bank = nameAndBank[2];
        Threeuple<String, Double, String> bankThreeuple = new Threeuple<>(name2, balance, bank);

        System.out.println(addressThreeuple);
        System.out.println(beerThreeuple);
        System.out.println(bankThreeuple);
    }
}
