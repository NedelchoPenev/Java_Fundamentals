package exercise.P07_Car_Salesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, -1, "n/a");
    }

    public String getModel() {
        return model;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("  %s:\n" +
                "    Power: %d\n" +
                "    Displacement: %s\n" +
                "    Efficiency: %s\n",
                this.model,
                this.power,
                this.displacement == -1 ? "n/a" : this.displacement,
                this.efficiency);

    }
}

