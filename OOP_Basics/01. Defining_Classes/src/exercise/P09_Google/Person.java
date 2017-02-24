package exercise.P09_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String namePerson;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String namePerson) {
        this.namePerson = namePerson;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addParen(Parent parent){
        this.parents.add(parent);
    }

    public void addChild(Child child){
        this.children.add(child);
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder person = new StringBuilder();
        person.append(this.namePerson).append(System.lineSeparator());
        person.append("Company:").append(System.lineSeparator());
        if (this.company != null){
            person.append(this.company);
            person.append(System.lineSeparator());
        }
        person.append("Car:").append(System.lineSeparator());
        if (this.car != null){
            person.append(this.car);
            person.append(System.lineSeparator());
        }
        person.append("Pokemon:");
        person.append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            person.append(pokemon);
            person.append(System.lineSeparator());
        }
        person.append("Parents:");
        person.append(System.lineSeparator());
        for (Parent parent : parents) {
            person.append(parent);
            person.append(System.lineSeparator());
        }
        person.append("Children:");
        person.append(System.lineSeparator());
        for (Child child : children) {
            person.append(child);
            person.append(System.lineSeparator());
        }

        return person.toString();
    }
}
