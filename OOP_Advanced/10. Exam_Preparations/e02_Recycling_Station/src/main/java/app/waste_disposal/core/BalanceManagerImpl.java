package app.waste_disposal.core;

import app.waste_disposal.contracts.BalanceManager;
import app.waste_disposal.contracts.ProcessingData;

public class BalanceManagerImpl implements BalanceManager {

    private double energy;
    private double capital;

    @Override
    public void processData(ProcessingData processingData){
        this.energy += processingData.getEnergyBalance();
        this.capital += processingData.getCapitalBalance();
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public double getCapital() {
        return capital;
    }
}
