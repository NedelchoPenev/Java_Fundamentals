package exercise.P03_Wild_farm.animals;

public class Zebra extends Mammal {

    public Zebra(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }
}
