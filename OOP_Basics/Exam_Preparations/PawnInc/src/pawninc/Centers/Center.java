package pawninc.Centers;

import pawninc.Animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Center {

    private String name;
    private List<Animal> animals;

    protected Center(String name) {
        this.setName(name);
        this.setAnimals(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.animals);
    }

    private void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void register(Animal animal){
        this.animals.add(animal);
    }

    public void registerAll(List<Animal> animals){
        this.animals.addAll(animals);
    }

    public void remove(List<Animal> animals){
        this.animals.removeAll(animals);
    }
}
