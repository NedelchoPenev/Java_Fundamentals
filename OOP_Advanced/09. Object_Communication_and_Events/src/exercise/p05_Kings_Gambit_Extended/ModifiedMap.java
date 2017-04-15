package exercise.p05_Kings_Gambit_Extended;

import exercise.p05_Kings_Gambit_Extended.contracts.SoldierDeathListener;
import exercise.p05_Kings_Gambit_Extended.events.SoldierDeathEvent;

import java.util.LinkedHashMap;

public class ModifiedMap<K, V> extends LinkedHashMap<K,V> implements SoldierDeathListener {

    @Override
    public void handleSoldierDeath(SoldierDeathEvent event) {
        this.remove(event.getName());
    }
}
