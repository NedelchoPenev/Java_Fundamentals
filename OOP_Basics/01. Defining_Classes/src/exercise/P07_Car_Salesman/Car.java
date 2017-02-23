package exercise.P07_Car_Salesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s:", this.model)).append(System.lineSeparator());
        stringBuilder.append(this.engine.toString());
        stringBuilder.append(String.format("  Weight: %s", this.weight == -1 ? "n/a" : this.weight)).append(System.lineSeparator());
        stringBuilder.append(String.format("  Color: %s", this.color));

        return stringBuilder.toString();
    }
}