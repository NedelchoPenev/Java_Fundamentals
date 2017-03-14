package Lab.P02_Car_Shop_Extend;

import java.io.Serializable;

public class Seat implements Sellable, Serializable, Car {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
        this.setCountryProduced(countryProduced);
        this.setPrice(price);
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
    public Integer getHorsePower() {
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
    public Double getPrice() {
        return this.price;
    }

    private void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                this.getModel(),
                this.getCountryProduced(),
                Car.TIRES);
    }
}
