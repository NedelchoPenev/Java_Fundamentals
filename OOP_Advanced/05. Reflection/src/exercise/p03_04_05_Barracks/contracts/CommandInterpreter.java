package exercise.p03_04_05_Barracks.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName) throws ReflectiveOperationException;
}
