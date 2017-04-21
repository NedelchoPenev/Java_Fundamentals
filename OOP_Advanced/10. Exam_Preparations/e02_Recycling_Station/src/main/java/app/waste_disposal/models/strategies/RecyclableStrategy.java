package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.ProcessingDataImpl;

public class RecyclableStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energy = 0 - (garbage.getWeight() * garbage.getVolumePerKg()) / 2;
        double capital = garbage.getWeight() * 400;
        return new ProcessingDataImpl(energy, capital);
    }
}
