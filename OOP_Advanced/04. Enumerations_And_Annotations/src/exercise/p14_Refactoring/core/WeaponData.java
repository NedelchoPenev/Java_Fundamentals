package exercise.p14_Refactoring.core;

import exercise.p14_Refactoring.interfaces.Item;
import exercise.p14_Refactoring.interfaces.ItemData;

import java.util.HashMap;

public class WeaponData implements ItemData {

    private HashMap<String, Item> items;

    public WeaponData() {
        this.items = new HashMap<>();
    }

    @Override
    public void addItem(String name, Item weapon) {
        this.items.put(name, weapon);
    }

    @Override
    public Item getItem(String name) {
        return this.items.get(name);
    }
}
