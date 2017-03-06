package exercise.P02_Vehicles_Extension.modules;

public class Bus extends Vehicle{

    private final double WITH_PEOPLE = 1.4;

    private double fullFuelCon;
    private double emptyFuelCon;

    public Bus(double fuelQuantity, double fuelConsummation, double tankCapacity) {
        super(fuelQuantity, fuelConsummation, tankCapacity);
        this.emptyFuelCon = fuelConsummation;
        this.fullFuelCon = fuelConsummation + WITH_PEOPLE;
    }

    @Override
    public void drive(double km, boolean additionalCondition) {
        if (!additionalCondition){
            this.setFuelConsummation(fullFuelCon);
            super.drive(km);
        } else {
            setFuelConsummation(emptyFuelCon);
            super.drive(km);
        }
    }
}
