package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import enums.Status;
import models.emergencies.Emergency;
import models.emergencies.OrderEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

public class RegisterOrderEmergencyCommand extends BaseCommand implements Executable {

    @InjectArgs
    private String[] params;
    private RegistrationTime registrationTime;
    private Emergency emergency;

    public RegisterOrderEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[2].toUpperCase());
        String statusValue = this.params[4].replaceAll("-","_").toUpperCase();
        Status status = Status.valueOf(statusValue);
        this.createRegistrationTime(this.params[3]);
        this.emergency = new OrderEmergency(description, level, this.registrationTime, status);
        return super.getManagementSystem().registerOrderEmergency(this.emergency);
    }

    private void createRegistrationTime(String registrationTime) {
        this.registrationTime = new RegistrationTimeImpl(registrationTime);
    }
}
