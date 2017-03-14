package lab.P01_Car_Shop;

import java.io.Serializable;

public class Seat implements Car, Serializable {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
        this.setCountryProduced(countryProduced);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    private String getCountryProduced() {
        return countryProduced;
    }

    private void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is Leon produced in %s and have %d tires",
                this.getCountryProduced(),
                TIRES);
    }
}
