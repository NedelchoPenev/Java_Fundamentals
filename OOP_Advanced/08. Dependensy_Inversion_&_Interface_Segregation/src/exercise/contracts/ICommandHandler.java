package exercise.contracts;

import exercise.exeptions.*;

public interface ICommandHandler {

    String executeCommand(String name, String... parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;

}
