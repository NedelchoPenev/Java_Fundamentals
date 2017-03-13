package Need_For_Speed.Cars;

import Need_For_Speed.Races.Race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;
    private List<Race> races;
    private boolean inGarage;
    private List<String> addOns;
    private int stars;

    Car(String brand,
        String model,
        int yearOfProduction,
        int horsepower,
        int acceleration,
        int suspension,
        int durability) {

        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
        this.races = new ArrayList<>();
        this.inGarage = false;
        this.addOns = new ArrayList<>();

    }

    public void addAddOns(String addOn){
        this.addOns.add(addOn);
    }

    List<String> getAddOns() {
        return addOns;
    }

    int getStars() {
        return stars;
    }

    public void increaseStars(int tuneIndex){
        this.stars += tuneIndex;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private int getYearOfProduction() {
        return yearOfProduction;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public List<Race> isInRaces() {
        return Collections.unmodifiableList(this.races);
    }

    public boolean isInGarage() {
        return inGarage;
    }

    public void raceParticipant(Race race){
        this.races.add(race);
    }

    public void removeFromRace(Race race){
        this.races.remove(race);
    }

    public void park(Boolean isInGarage){
        this.inGarage = isInGarage;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d\n" +
                "%d HP, 100 m/h in %d s\n" +
                "%d Suspension force, %d Durability\n",
                this.getBrand(),
                this.getModel(),
                this.getYearOfProduction(),
                this.getHorsepower(),
                this.getAcceleration(),
                this.getSuspension(),
                this.getDurability());
    }
}
