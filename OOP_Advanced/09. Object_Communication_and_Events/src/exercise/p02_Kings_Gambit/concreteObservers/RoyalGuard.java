package exercise.p02_Kings_Gambit.concreteObservers;

import exercise.p02_Kings_Gambit.observer.UnderAttackListenerP;

public class RoyalGuard implements UnderAttackListenerP {

    private String name;

    public RoyalGuard(String name) {
        this.name = name;
    }

    @Override
    public void activateDefenders() {
        System.out.printf("Royal Guard %s is defending!%n", this.name);
    }
}
