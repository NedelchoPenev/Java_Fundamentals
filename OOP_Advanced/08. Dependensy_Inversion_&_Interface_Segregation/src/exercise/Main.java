package exercise;

import exercise.contracts.IBoatSimulatorController;
import exercise.contracts.ICommandHandler;
import exercise.controllers.BoatSimulatorController;
import exercise.core.CommandHandler;
import exercise.core.Engine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        IBoatSimulatorController controller = new BoatSimulatorController();
        ICommandHandler commandHandler = new CommandHandler(controller);
        Engine engine = new Engine(commandHandler);
        engine.run();
    }
}
