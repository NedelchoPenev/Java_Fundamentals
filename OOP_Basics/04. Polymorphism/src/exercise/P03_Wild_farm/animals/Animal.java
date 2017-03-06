package exercise.P03_Wild_farm.animals;

import exercise.P03_Wild_farm.foods.Food;

public abstract class Animal {

    private String type;
    private String name;
    private double weight;
    private int foodEaten;

    Animal(String type, String name, double weight) {
        this.setType(type);
        this.setName(name);
        this.setWeight(weight);
    }

    String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    int getFoodEaten() {
        return foodEaten;
    }

    void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract String makeSound();

    public abstract void eat(Food food);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("%s[%s, ",
                        this.getType(),
                        this.getName()));
        return sb.toString();
    }
}
