package exercise.p03_04_05_Barracks.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
