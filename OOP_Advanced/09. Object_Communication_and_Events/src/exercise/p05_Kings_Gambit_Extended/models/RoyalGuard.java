package exercise.p05_Kings_Gambit_Extended.models;

import exercise.p05_Kings_Gambit_Extended.events.UnderAttackEvent;

public class RoyalGuard extends Soldier {

    private static final int ROYAL_GUARD_HITS = 3;

    public RoyalGuard(String name) {
        super(name, ROYAL_GUARD_HITS);
    }

    @Override
    public void handleUnitAttacked(UnderAttackEvent event) {
        System.out.println(String.format("Royal Guard %s is defending!",this.getName()));
    }
}
