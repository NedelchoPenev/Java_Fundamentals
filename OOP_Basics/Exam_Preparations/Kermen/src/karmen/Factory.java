package karmen;

import karmen.city.*;
import karmen.persons.Child;

import java.util.List;

public class Factory {

    City karmen;

    public Factory() {
        this.karmen = new City();
    }

    public void youngCouple(double salary1, double salary2, double TV, double fridge, double laptop){
        Home youngCouple = new YoungCoupleHome(salary1, salary2, TV, fridge, laptop);
        this.karmen.addHome(youngCouple);
    }

    public void youngCoupleWithChildren(double salary1, double salary2, double TV, double fridge, double laptop, List<Child> children){

        Home youngCoupleWithChildren =
                new YoungCoupleWithChildrenHome(salary1, salary2, TV, fridge, laptop, children);
        this.karmen.addHome(youngCoupleWithChildren);
    }

    public void aloneYoung(double salary, double laptop){
        Home aloneYoung = new AloneYoungHome(salary, laptop);
        this.karmen.addHome(aloneYoung);
    }

    public void oldCouple(double pension1, double pension2, double TV, double fridge, double stove) {
        Home oldCouple = new OldCoupleHome(pension1, pension2, TV, fridge, stove);
        this.karmen.addHome(oldCouple);
    }

    public void aloneOld(double pension){
        Home aloneOld = new AloneOldHome(pension);
        this.karmen.addHome(aloneOld);
    }

    public String evn(){
        return "Total consumption: " + karmen.totalConsummation();
    }

    public void evnBill(){
        this.karmen.payBills();
    }

    void paySalaries(){
        this.karmen.paySalaries();
    }

    String democracy(){
        return String.format("Total population: %d", karmen.getPopulation());
    }
}
