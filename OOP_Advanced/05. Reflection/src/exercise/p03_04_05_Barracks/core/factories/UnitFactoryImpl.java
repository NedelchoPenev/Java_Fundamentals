package exercise.p03_04_05_Barracks.core.factories;

import exercise.p03_04_05_Barracks.contracts.Unit;
import exercise.p03_04_05_Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"exercise.p03_04_05_Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ReflectiveOperationException {

		Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor constructor = unitClass.getConstructor();
        constructor.setAccessible(true);
        return (Unit) constructor.newInstance();
	}
}
