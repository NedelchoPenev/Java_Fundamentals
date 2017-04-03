package exercise.p03_04_05_Barracks;

import exercise.p03_04_05_Barracks.contracts.CommandInterpreter;
import exercise.p03_04_05_Barracks.contracts.Repository;
import exercise.p03_04_05_Barracks.contracts.Runnable;
import exercise.p03_04_05_Barracks.contracts.UnitFactory;
import exercise.p03_04_05_Barracks.core.factories.CommandInterpreterImpl;
import exercise.p03_04_05_Barracks.core.Engine;
import exercise.p03_04_05_Barracks.core.factories.UnitFactoryImpl;
import exercise.p03_04_05_Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
		Runnable engine = new Engine(commandInterpreter);
		engine.run();
	}
}
