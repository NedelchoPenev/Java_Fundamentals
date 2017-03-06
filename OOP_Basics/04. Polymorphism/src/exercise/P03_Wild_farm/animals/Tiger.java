package exercise.P03_Wild_farm.animals;

import exercise.P03_Wild_farm.foods.Food;
import exercise.P03_Wild_farm.foods.Meat;

public class Tiger extends Felime {

    public Tiger(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat){
            this.setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
