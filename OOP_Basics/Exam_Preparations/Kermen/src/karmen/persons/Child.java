package karmen.persons;

import karmen.items.Toy;

import java.util.Collections;
import java.util.List;

public class Child {

    private double foodCost;
    private List<Toy> toys;

    public Child(double foodCost, List<Toy> toys) {
        this.setFoodCost(foodCost);
        this.setToys(toys);
    }

    public double getFoodCost() {
        return foodCost;
    }

    private void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public List<Toy> getToys() {
        return Collections.unmodifiableList(this.toys);
    }

    private void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public double getTotalChildCost(){
        return this.foodCost + this.toys.stream().mapToDouble(Toy::getCost).sum();
    }
}
