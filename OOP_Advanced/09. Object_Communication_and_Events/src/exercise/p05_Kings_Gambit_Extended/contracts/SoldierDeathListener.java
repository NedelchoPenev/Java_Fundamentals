package exercise.p05_Kings_Gambit_Extended.contracts;

import exercise.p05_Kings_Gambit_Extended.events.SoldierDeathEvent;

public interface SoldierDeathListener {

    void handleSoldierDeath(SoldierDeathEvent event);
}
