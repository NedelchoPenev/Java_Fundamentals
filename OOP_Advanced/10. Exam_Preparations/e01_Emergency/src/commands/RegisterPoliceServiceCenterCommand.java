package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import models.centers.EmergencyCenter;
import models.centers.PoliceServiceCenter;

public class RegisterPoliceServiceCenterCommand extends BaseCommand implements Executable {

    @InjectArgs
    private String[] params;
    private EmergencyCenter center;

    public RegisterPoliceServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String centerName = this.params[1];
        Integer amountOfEmergencies = Integer.valueOf(this.params[2]);

        this.center = new PoliceServiceCenter(centerName, amountOfEmergencies);
        return super.getManagementSystem().registerPoliceServiceCenter(this.center);
    }
}
