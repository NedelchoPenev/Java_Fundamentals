package exercise.P03_Wild_farm.animals;

import exercise.P03_Wild_farm.foods.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String type, String name, double weight, String livingRegion, String breed) {
        super(type, name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat noTrailing = new DecimalFormat("0.######");
        StringBuilder sb = new StringBuilder(
                String.format("%s[%s, ",
                        this.getType(),
                        this.getName()));
        sb.append(String.format("%s, ", this.breed));
        sb.append(String.format("%s, %s, %d]",
                noTrailing.format(this.getWeight()),
                this.getLivingRegion(),
                this.getFoodEaten()));
        return sb.toString();
    }
}
