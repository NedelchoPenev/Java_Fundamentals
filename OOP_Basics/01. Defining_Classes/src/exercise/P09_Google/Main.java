package exercise.P09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> persons = new HashMap<>();
        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("End")) {
                break;
            }

            String personName = input[0];
            String currentClass = input[1];

            if (!persons.containsKey(personName)){
                persons.put(personName, new Person(personName));
            }
            Person person = persons.get(personName);

            switch (currentClass){
                case "company":
                    addCompany(input, person);
                    break;
                case "pokemon":
                    addPokemon(input, person);
                    break;
                case "parents":
                    addParent(input, person);
                    break;
                case "children":
                    addChild(input, person);
                    break;
                case "car":
                    addCar(input, person);
                    break;
            }
        }

        String personInfo = console.readLine();
        System.out.println(persons.get(personInfo));
    }

    private static void addChild(String[] input, Person person) {
        String childName = input[2];
        String childBirthday = input[3];
        Child child = new Child(childName, childBirthday);
        person.addChild(child);
    }

    private static void addParent(String[] input, Person person) {
        String parentName = input[2];
        String parentBirthday = input[3];
        Parent parent = new Parent(parentName, parentBirthday);
        person.addParen(parent);
    }

    private static void addPokemon(String[] input, Person person) {
        String pokemonName = input[2];
        String pokemonType = input[3];
        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        person.addPokemon(pokemon);
    }

    private static void addCar(String[] input, Person person) {
        String carModel = input[2];
        int carSpeed = Integer.parseInt(input[3]);
        Car car = new Car(carModel, carSpeed);
        person.setCar(car);
    }

    private static void addCompany(String[] input, Person person) {
        String companyName = input[2];
        String department = input[3];
        double salary = Double.parseDouble(input[4]);
        Company company = new Company(companyName, department, salary);
        person.setCompany(company);
    }
}
