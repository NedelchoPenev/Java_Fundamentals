package exercise.P05_Pizza_Calories;

public class Dough {

    private final int BASE_CALORIES = 2;

    private String type;
    private String bakingTechnique;
    private double weight;

    Dough(String type, String bakingTechnique, double weight) {
        this.setType(type);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        if (!type.equalsIgnoreCase("White") && !type.equalsIgnoreCase("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.type = type;
    }

    private String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equalsIgnoreCase("Crispy") &&
                !bakingTechnique.equalsIgnoreCase("Chewy") &&
                !bakingTechnique.equalsIgnoreCase("Homemade")){

            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    double calculateDoughCalories() {
        return (this.getWeight() * BASE_CALORIES) * this.typeModifier() * this.techniqueModifier();
    }

    private double typeModifier() {
        if (this.getType().toLowerCase().equals("white")) {
            return 1.5;
        }

        return 1.0;
    }

    private double techniqueModifier() {
        switch (this.getBakingTechnique().toLowerCase()) {
            case "crispy":
                return 0.9;
            case "chewy":
                return 1.1;
            default:
                return 1.0;
        }
    }
}
