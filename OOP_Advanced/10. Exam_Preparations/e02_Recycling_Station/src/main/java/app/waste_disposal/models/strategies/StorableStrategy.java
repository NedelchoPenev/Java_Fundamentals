package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.ProcessingDataImpl;

public class StorableStrategy implements GarbageDisposalStrategy{

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energy = 0 - (garbage.getWeight() * garbage.getVolumePerKg()) * 0.13;
        double capital = 0 - (garbage.getWeight() * garbage.getVolumePerKg()) * 0.65;
        return new ProcessingDataImpl(energy, capital);
    }
}
