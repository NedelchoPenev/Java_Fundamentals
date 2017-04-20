package interpreters;

import annotations.InjectArgs;
import annotations.InjectType;
import commands.Executable;
import core.ManagementSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String COMMAND_SUFFIX = "Command";
    private static final String PATH = "commands.";

    private ManagementSystem managementSystem;

    public CommandInterpreter(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    @Override
    public Executable interpretCommand(String line) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Executable executable = null;
        String[] params = line.split("\\|+");
        String command = params[0];
        Class<Executable> executableClass = (Class<Executable>) Class.forName(PATH + command + COMMAND_SUFFIX);
        Constructor<Executable> constructor = executableClass.getDeclaredConstructor(ManagementSystem.class);
        executable = constructor.newInstance(this.managementSystem);
        this.injectDependencies(executable, params);
        return executable;
    }

    private void injectDependencies(Executable executable, String[] input) throws IllegalAccessException {
        Field[] fields = executable.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectArgs.class)){
                field.setAccessible(true);
                field.set(executable, input);
                return;
            } else if(field.isAnnotationPresent(InjectType.class)){
                field.setAccessible(true);
                field.set(executable, input[1]);
                return;
            }
        }
    }
}
