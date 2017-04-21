package app.waste_disposal.contracts;

public interface BalanceManager {

    void processData(ProcessingData processingData);

    double getEnergy();

    double getCapital();
}
