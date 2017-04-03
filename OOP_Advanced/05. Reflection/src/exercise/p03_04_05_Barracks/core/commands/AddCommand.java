package exercise.p03_04_05_Barracks.core.commands;

import exercise.p03_04_05_Barracks.annotations.Inject;
import exercise.p03_04_05_Barracks.contracts.Repository;
import exercise.p03_04_05_Barracks.contracts.Unit;
import exercise.p03_04_05_Barracks.contracts.UnitFactory;

public class AddCommand extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
