package exercise.p14_Refactoring.core;

import exercise.p14_Refactoring.enums.WeaponsType;
import exercise.p14_Refactoring.interfaces.Item;
import exercise.p14_Refactoring.interfaces.ItemCreator;
import exercise.p14_Refactoring.models.Weapon;

public class WeaponCreator implements ItemCreator {

    @Override
    public Item create(String[] itemData) {
        String name = itemData[2];
        WeaponsType type = WeaponsType.valueOf(itemData[1]);
        return new Weapon(type, name);
    }
}
