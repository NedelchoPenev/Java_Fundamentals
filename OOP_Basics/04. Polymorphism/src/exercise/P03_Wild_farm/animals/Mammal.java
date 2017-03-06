package exercise.P03_Wild_farm.animals;

import exercise.P03_Wild_farm.foods.Food;
import exercise.P03_Wild_farm.foods.Vegetable;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String type, String name, double weight, String livingRegion) {
        super(type, name, weight);
        this.livingRegion = livingRegion;
    }

    String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable){
            this.setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException(
                    String.format("%ss are not eating that type of food!", this.getClass().getSimpleName()));
        }
    }

    @Override
    public String toString() {
        DecimalFormat noTrailing = new DecimalFormat("0.######");
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("%s, %s, %d]",
                noTrailing.format(this.getWeight()),
                this.getLivingRegion(),
                this.getFoodEaten()));
        return sb.toString();
    }
}
