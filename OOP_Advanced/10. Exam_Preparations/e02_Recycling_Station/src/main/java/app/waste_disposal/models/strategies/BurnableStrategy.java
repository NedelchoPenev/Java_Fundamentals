package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.ProcessingDataImpl;

public class BurnableStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energy = (garbage.getWeight() * garbage.getVolumePerKg()) * 0.8;
        double capital = 0;
        return new ProcessingDataImpl(energy, capital);
    }
}
