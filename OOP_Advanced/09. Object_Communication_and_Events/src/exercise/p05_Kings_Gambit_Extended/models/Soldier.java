package exercise.p05_Kings_Gambit_Extended.models;

import exercise.p05_Kings_Gambit_Extended.contracts.Attackable;
import exercise.p05_Kings_Gambit_Extended.contracts.SoldierDeathListener;
import exercise.p05_Kings_Gambit_Extended.contracts.UnderAttackListener;
import exercise.p05_Kings_Gambit_Extended.events.SoldierDeathEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class Soldier implements UnderAttackListener, Attackable {

    private String name;
    private int hitsLeft;
    private List<SoldierDeathListener> observers;

    protected Soldier(String name,int hits){
        this.setName(name);
        this.hitsLeft = hits;
        this.observers = new ArrayList<>();
    }

    protected int getHitsLeft(){
        return this.hitsLeft;
    }

    protected void setHitsLeft(int hits){
        this.hitsLeft = hits;
    }

    private void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void respondToAttack() {
        this.setHitsLeft(this.getHitsLeft() - 1);
        if(this.getHitsLeft() == 0){
            this.fireSoldierDeathEvent();
        }
    }

    public void addSoldierDeathListener(SoldierDeathListener observer){
        this.observers.add(observer);
    }

    public void removeSoldierDeathListener(SoldierDeathListener observer){
        this.observers.remove(observer);
    }

    protected void fireSoldierDeathEvent(){
        SoldierDeathEvent event = new SoldierDeathEvent(this,this.getName());
        for (SoldierDeathListener observer : observers) {
            observer.handleSoldierDeath(event);
        }
    }
}
