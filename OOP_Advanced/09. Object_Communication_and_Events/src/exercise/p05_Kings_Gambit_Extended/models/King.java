package exercise.p05_Kings_Gambit_Extended.models;

import exercise.p05_Kings_Gambit_Extended.contracts.Attackable;
import exercise.p05_Kings_Gambit_Extended.contracts.SoldierDeathListener;
import exercise.p05_Kings_Gambit_Extended.contracts.UnderAttackListener;
import exercise.p05_Kings_Gambit_Extended.events.SoldierDeathEvent;
import exercise.p05_Kings_Gambit_Extended.events.UnderAttackEvent;

import java.util.ArrayList;
import java.util.List;

public class King implements SoldierDeathListener, Attackable {
    private String name;
    private List<UnderAttackListener> observers;

    public King(String name){
        this.setName(name);
        this.observers = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        this.name = name;
    }

    public void addUnderAttackListener(UnderAttackListener observer){
        this.observers.add(observer);
    }

    public void removeUnderAttackListener(UnderAttackListener observer){
        this.observers.remove(observer);
    }

    @Override
    public void respondToAttack() {
        System.out.println(String.format("King %s is under attack!",this.getName()));
        this.fireUnderAttackEvent();
    }

    protected void fireUnderAttackEvent(){
        UnderAttackEvent event = new UnderAttackEvent(this);
        for (UnderAttackListener observer : observers) {
            observer.handleUnitAttacked(event);
        }
    }

    @Override
    public void handleSoldierDeath(SoldierDeathEvent event) {
        this.observers.remove(event.getSource());
    }
}
