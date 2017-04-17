package exercise.core;

import exercise.contracts.IBoatSimulatorController;
import exercise.contracts.ICommandHandler;
import exercise.enumeration.EngineType;
import exercise.exeptions.*;

public class CommandHandler implements ICommandHandler {

    private IBoatSimulatorController controller;

    public CommandHandler(IBoatSimulatorController controller) {
        this.setController(controller);
    }

    private void setController(IBoatSimulatorController controller) {
        this.controller = controller;
    }

    public String executeCommand(String name, String... parameters) throws DuplicateModelException,
            NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException,
            InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                EngineType engineType = EngineType.valueOf(parameters[4]);
                return this.controller.createBoatEngine(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]),
                        engineType);

            case "CreateRowBoat":
                return this.controller.createRowBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]));
            case "CreateSailBoat":
                return this.controller.createSailBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]));
            case "CreatePowerBoat":
                return this.controller.createPowerBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        parameters[3],
                        parameters[4]);
            case "CreateYacht":
                return this.controller.createYacht(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        parameters[3],
                        Integer.parseInt(parameters[4]));
            case "OpenRace":
                return this.controller.openRace(
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]),
                        Boolean.parseBoolean(parameters[4]));
            case "SignUpBoat":
                return this.controller.signUpBoat(parameters[1]);
            case "StartRace":
                return this.controller.startRace();
            case "GetStatistic":
                return this.controller.getStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
