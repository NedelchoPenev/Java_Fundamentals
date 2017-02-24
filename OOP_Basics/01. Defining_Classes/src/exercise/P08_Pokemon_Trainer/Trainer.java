package exercise.P08_Pokemon_Trainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void increaseBadges() {
        this.numberOfBadges++;
    }

    public void decreasePokemonHealth() {
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon curPok = pokemons.get(i);
            curPok.healthDecreased();
            if (curPok.isDead()){
                pokemons.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}

