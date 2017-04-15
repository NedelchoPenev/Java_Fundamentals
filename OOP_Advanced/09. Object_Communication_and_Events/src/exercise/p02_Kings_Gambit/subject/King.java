package exercise.p02_Kings_Gambit.subject;

import exercise.p02_Kings_Gambit.observer.UnderAttackListenerP;

import java.util.LinkedHashMap;

public class King {

    private String name;
    private LinkedHashMap<String, UnderAttackListenerP> defenders;

    public King(String name) {
        this.name = name;
        this.defenders = new LinkedHashMap<>();
    }

    public void kingIsUnderAttack() {
        System.out.printf("King %s is under attack!%n", this.name);
        this.notifyDefenders();
    }

    public void addDefender(String name, UnderAttackListenerP defender){
        this.defenders.put(name, defender);
    }

    public void removeDefender(String name){
        this.defenders.remove(name);
    }

    private void notifyDefenders(){
        for (UnderAttackListenerP defender : this.defenders.values()) {
            defender.activateDefenders();
        }
    }
}
