package lab.P04_Fragile_Base_Class;

import java.util.Collections;

public class Predator extends Animal{

    private int health;

    public void feed(Food food){
        super.eat(food);
        this.health++;
    }

    public void feedAll(Food[] foods){
        Collections.addAll(super.foodEaten, foods);
        this.health += foods.length;
    }
}

