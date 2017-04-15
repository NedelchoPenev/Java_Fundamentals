package exercise.p02_Kings_Gambit.concreteObservers;

import exercise.p02_Kings_Gambit.observer.UnderAttackListenerP;

public class Footman implements UnderAttackListenerP {

    private String name;

    public Footman(String name) {
        this.name = name;
    }

    @Override
    public void activateDefenders() {
        System.out.printf("Footman %s is panicking!%n", this.name);
    }
}
