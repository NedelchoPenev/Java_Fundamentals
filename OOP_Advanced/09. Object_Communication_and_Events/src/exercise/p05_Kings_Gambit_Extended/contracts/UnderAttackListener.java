package exercise.p05_Kings_Gambit_Extended.contracts;

import exercise.p05_Kings_Gambit_Extended.events.UnderAttackEvent;

public interface UnderAttackListener {

    void handleUnitAttacked(UnderAttackEvent event);
}
