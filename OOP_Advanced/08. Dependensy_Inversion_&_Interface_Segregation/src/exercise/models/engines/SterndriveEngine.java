package exercise.models.engines;

public class SterndriveEngine extends BaseEngine{
    private static final int MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
        setOutput();
    }

    public void setOutput() {
        if (this.getOutput() != 0) {
            setCachedOutput(this.getOutput());
        }

        setCachedOutput((this.getHorsepower() * MULTIPLIER) + this.getDisplacement());
    }
}
