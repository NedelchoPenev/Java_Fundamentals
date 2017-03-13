package Need_For_Speed.Cars;

public class PerformanceCar extends Car{

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int
            suspension, int durability) {

        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        increaseHorsepower();
        decreaseSuspension();
    }

    private void increaseHorsepower() {
        super.setHorsepower(this.getHorsepower() + (this.getHorsepower() * 50) / 100);
    }

    private void decreaseSuspension() {
        super.setSuspension(this.getSuspension() - (this.getSuspension() * 25) / 100);
    }

    private String addOns(){
        if (this.getAddOns().isEmpty()){
            return "None";
        }

        return String.join(", ", this.getAddOns());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Add-ons: %s", this.addOns());
    }
}
