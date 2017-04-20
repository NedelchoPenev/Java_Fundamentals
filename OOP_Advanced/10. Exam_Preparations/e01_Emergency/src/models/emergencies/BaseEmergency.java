package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public abstract class BaseEmergency implements Emergency{

    private String description;
    private EmergencyLevel emergencyLevel;
    private RegistrationTime registrationTimeImpl;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public EmergencyLevel getEmergencyLevel() {
        return this.emergencyLevel;
    }

    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    @Override
    public RegistrationTime getRegistrationTime() {
        return this.registrationTimeImpl;
    }

    private void setRegistrationTime(RegistrationTime registrationTimeImpl) {
        this.registrationTimeImpl = registrationTimeImpl;
    }
}
