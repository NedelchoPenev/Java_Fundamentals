package exercise.P06_Animals.models;

public class Cat extends Animal {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String soundProduce() {
        return "MiauMiau";
    }
}
