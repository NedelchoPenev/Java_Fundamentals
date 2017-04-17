package exercise.models.engines;

import exercise.contracts.Modable;
import exercise.utility.Constants;
import exercise.utility.Validator;

public abstract class BaseEngine implements Modable{

    private int cachedOutput;
    private String model;
    private int horsepower;
    private int displacement;

    protected BaseEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    public int getOutput() {
        return this.cachedOutput;
    }

    protected void setCachedOutput(int cachedOutput) {
        this.cachedOutput = cachedOutput;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    private void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
