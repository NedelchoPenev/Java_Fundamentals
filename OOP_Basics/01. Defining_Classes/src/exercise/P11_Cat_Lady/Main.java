package exercise.P11_Cat_Lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Cat> cats = new TreeMap<>();
        while (true) {
            String input = console.readLine();
            if ("End".equals(input)) {
                break;
            }

            String[] split = input.split("\\s+");
            String breed = split[0];
            String catName = split[1];

            switch (breed){
                case "Siamese":
                    int decibelsOfMeows = Integer.parseInt(split[2]);
                    cats.put(catName, new Siamese(catName, decibelsOfMeows));
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(split[2]);
                    cats.put(catName, new Cymric(catName, furLength));
                    break;
                case "StreetExtraordinaire":
                    int earSize = Integer.parseInt(split[2]);
                    cats.put(catName, new StreetExtraordinaire(catName, earSize));
                    break;
            }
        }

        String searchedCat = console.readLine();
        System.out.println(cats.get(searchedCat));
    }
}
