package exercise.P05_Pizza_Calories;

public class Topping {

    private final int BASE_CALORIES = 2;

    private String type;
    private double weight;

    Topping(String type, double weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        if (!type.equalsIgnoreCase("meat") &&
                !type.equalsIgnoreCase("veggies") &&
                !type.equalsIgnoreCase("cheese") &&
                !type.equalsIgnoreCase("sauce")){

            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].", this.getType()));
        }
        this.weight = weight;
    }

    private double typeModifier() {
        switch (this.getType().toLowerCase()) {
            case "meat":
                return 1.2;
            case "veggies":
                return 0.8;
            case "cheese":
                return 1.1;
            default:
                return 0.9;
        }
    }

    double calculateToppingCalories(){
        return (this.getWeight() * BASE_CALORIES) * this.typeModifier();
    }
}


