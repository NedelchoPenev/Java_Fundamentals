package app.waste_disposal.core;

import app.waste_disposal.contracts.ManagementRequirement;

public class ManagementRequirementImpl implements ManagementRequirement {

    private double energy;
    private double capital;
    private String type;

    public ManagementRequirementImpl(double energy, double capital, String type) {
        this.energy = energy;
        this.capital = capital;
        this.type = type;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public double getCapital() {
        return capital;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void changeManagementRequirement(double energy, double capital, String type){
        this.energy = energy;
        this.capital = capital;
        this.type = type;
    }
}
