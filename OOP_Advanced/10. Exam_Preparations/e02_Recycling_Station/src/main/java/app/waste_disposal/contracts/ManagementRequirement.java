package app.waste_disposal.contracts;

public interface ManagementRequirement {

    double getEnergy();

    double getCapital();

    String getType();

    void changeManagementRequirement(double energy, double capital, String type);
}
