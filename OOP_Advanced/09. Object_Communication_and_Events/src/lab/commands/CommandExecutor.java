package lab.commands;

import lab.contracts.Command;
import lab.contracts.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
