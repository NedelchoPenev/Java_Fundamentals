package exercise.P08_Pokemon_Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (true) {
            String input = console.readLine();
            if ("Tournament".equals(input)) {
                break;
            }

            String[] split = input.split("\\s+");
            String trainerName = split[0];
            String pokemonName = split[1];
            String pokemonElement = split[2];
            int pokemonHealth = Integer.parseInt(split[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemon(pokemon);

        }

        while (true) {
            String searchedElement = console.readLine();
            if ("End".equals(searchedElement)) {
                break;
            }

            for (Trainer trainer : trainers.values()) {
                long pokemonsHaveElement = trainer.getPokemons()
                        .stream()
                        .filter(p -> p.getElement().equals(searchedElement))
                        .count();
                if (pokemonsHaveElement > 0){
                    trainer.increaseBadges();
                } else {
                    trainer.decreasePokemonHealth();
                }
            }
        }

        trainers.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges()))
                .forEach(System.out::println);
    }
}
