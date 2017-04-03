package exercise.p03_04_05_Barracks.core.commands;

import exercise.p03_04_05_Barracks.annotations.Inject;
import exercise.p03_04_05_Barracks.contracts.Repository;

public class ReportCommand extends Command {

    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        return this.repository.getStatistics();
    }
}
