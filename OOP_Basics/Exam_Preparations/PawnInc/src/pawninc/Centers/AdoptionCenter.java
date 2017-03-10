package pawninc.Centers;

import pawninc.Animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

public class AdoptionCenter extends Center{

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleansing(CleansingCenter center){
        List<Animal> animals = super.getAnimals()
                .stream().filter(a -> !a.isCleansed())
                .collect(Collectors.toList());

        super.remove(animals);
        center.registerAll(animals);
    }

    public void sendForCastration(CastrationCenter center){
        List<Animal> animals = super.getAnimals()
                .stream().filter(a -> !a.isCastrated())
                .collect(Collectors.toList());

        super.remove(animals);
        center.registerAll(animals);
    }

    public List<Animal> adopt(){
        List<Animal> animals = super.getAnimals()
                .stream().filter(Animal::isCleansed)
                .collect(Collectors.toList());
        super.remove(animals);

        return animals;
    }
}
