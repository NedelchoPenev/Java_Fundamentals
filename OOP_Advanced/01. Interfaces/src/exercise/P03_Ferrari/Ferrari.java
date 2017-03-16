package exercise.P03_Ferrari;

public class Ferrari implements Car {

    private static final String MODEL = "488-Spider";

    private String driverName;

    public Ferrari(String driverName) {
        this.setDriverName(driverName);
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gasPedal() {
        return "Zadu6avam sA!";
    }

    private String getDriverName() {
        return driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", MODEL, this.brakes(), this.gasPedal(), this.getDriverName());
    }
}
