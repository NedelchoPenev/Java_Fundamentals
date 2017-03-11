package karmen.city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private List<Home> homes;

    public City() {
        this.homes = new ArrayList<>();
    }

    public int getPopulation(){
        return this.homes.stream().mapToInt(Home::getNumberOfPeople).sum();
    }

    public double totalConsummation(){
        return this.homes.stream().mapToDouble(Home::getHomeConsummation).sum();
    }

    public void addHome(Home home){
        this.homes.add(home);
    }

    public void payBills(){
        List<Home> homesToRemove = new ArrayList<>();
        for (Home home : homes) {
            home.payBills();
            if (home.getIncome() < 0){
                homesToRemove.add(home);
            }
        }

        this.homes.removeAll(homesToRemove);
    }

    public void paySalaries(){
        this.homes.forEach(Home::paySalary);
    }
}
