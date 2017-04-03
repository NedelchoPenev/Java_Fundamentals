package exercise.p03_04_05_Barracks.core.commands;

import exercise.p03_04_05_Barracks.annotations.Inject;
import exercise.p03_04_05_Barracks.contracts.Repository;

public class RetireCommand extends Command{

    @Inject
    private Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        try {
            String unitType = this.getData()[1];
            this.repository.removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalArgumentException ex){
            return ex.getMessage();
        }
    }
}
