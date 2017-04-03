package exercise.p03_04_05_Barracks.contracts;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ReflectiveOperationException;
}