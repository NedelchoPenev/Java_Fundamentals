package exercise.P03_Wild_farm.animals;

import exercise.P03_Wild_farm.foods.Food;

public class Mouse extends Mammal {

    public Mouse(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
        if (food.getQuantity() <= 0){
            throw new IllegalArgumentException("A cheese was just eaten!");
        }
    }
}
