package exercise.P09_Google;

public class Pokemon {

    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        StringBuilder pokemon = new StringBuilder();
        pokemon.append(String.format("%s %s", this.name, this.type));
        return pokemon.toString();
    }
}
