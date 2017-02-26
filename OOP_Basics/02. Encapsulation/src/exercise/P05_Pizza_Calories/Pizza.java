package exercise.P05_Pizza_Calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.setToppings(new ArrayList<>());
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() && name.trim().length() == 0 && (name.length() < 1 || name.length() > 15)){
            throw new IllegalArgumentException(String.format("%s should be between 1 and 15 symbols.", this.getName()));
        }
        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    private List<Topping> getToppings() {
        return toppings;
    }

    private void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    void setDough(Dough dough) {
        this.dough = dough;
    }

    void addTopping(Topping topping){
        this.getToppings().add(topping);
    }

    private double getTotalCalories(){
        double calories = this.dough.calculateDoughCalories();
        for (Topping topping : this.toppings) {
            calories += topping.calculateToppingCalories();
        }

        return calories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getTotalCalories());
    }
}
