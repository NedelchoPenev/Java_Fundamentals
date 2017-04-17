package exercise.models.engines;

public class JetEngine extends BaseEngine {

    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
        setOutput();
    }

    protected void setOutput() {
        if (this.getOutput() != 0) {
            setCachedOutput(this.getOutput());
        }

        setCachedOutput((this.getHorsepower() * MULTIPLIER) + this.getDisplacement());
    }
}
