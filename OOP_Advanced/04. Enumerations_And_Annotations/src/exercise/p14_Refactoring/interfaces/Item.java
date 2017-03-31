package exercise.p14_Refactoring.interfaces;

import exercise.p14_Refactoring.enums.Gems;

public interface Item {

    void addGem(Gems gem, int index);

    void removeGem(int index);

    String getName();

    String toString();

    double getItemLevel();

    int compareTo(Item other);
}
