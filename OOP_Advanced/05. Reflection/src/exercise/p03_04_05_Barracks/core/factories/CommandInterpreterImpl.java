package exercise.p03_04_05_Barracks.core.factories;

import exercise.p03_04_05_Barracks.annotations.Inject;
import exercise.p03_04_05_Barracks.contracts.CommandInterpreter;
import exercise.p03_04_05_Barracks.contracts.Executable;
import exercise.p03_04_05_Barracks.contracts.Repository;
import exercise.p03_04_05_Barracks.contracts.UnitFactory;
import exercise.p03_04_05_Barracks.core.commands.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMAND_PACKAGE_NAME= "exercise.p03_04_05_Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ReflectiveOperationException {

        String commandClassName =
                commandName.toUpperCase().charAt(0) + commandName.substring(1) + "Command";

        Class commandClass = Class.forName(COMMAND_PACKAGE_NAME + commandClassName);
        Constructor constructor = commandClass.getConstructor(String[].class);
        constructor.setAccessible(true);
        Executable executable = (Executable) constructor.newInstance((Object) data);
        this.injectDependencies(executable, commandClass);

        return executable;
    }

    private void injectDependencies(Executable commandInstance,
                                    Class<Command> commandClass) throws
            IllegalAccessException {
        Field[] commandFields = commandClass.getDeclaredFields();
        Field[] sourceFields = CommandInterpreterImpl.class.getDeclaredFields();

        for (Field field : commandFields) {
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }
            field.setAccessible(true);

            for (Field sourceField : sourceFields) {
                if (!sourceField.getType().equals(field.getType())) {
                    continue;
                }
                sourceField.setAccessible(true);
                field.set(commandInstance, sourceField.get(this));
            }
        }
    }
}
