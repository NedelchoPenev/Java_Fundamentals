package exercise.P06_Animals.models;

public class Frog extends Animal {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String soundProduce() {
        return "Frogggg";
    }
}
