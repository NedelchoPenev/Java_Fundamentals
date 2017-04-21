package app.waste_disposal.contracts;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpreter {

    String processCommands(String command, String[] input) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException;
}
