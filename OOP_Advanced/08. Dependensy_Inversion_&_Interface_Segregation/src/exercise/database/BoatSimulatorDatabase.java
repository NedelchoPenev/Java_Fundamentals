package exercise.database;

import exercise.contracts.Sailable;
import exercise.contracts.IRepository;
import exercise.models.engines.BaseEngine;

public class BoatSimulatorDatabase {

    private IRepository<Sailable> boats;
    private IRepository<BaseEngine> engines;

    public BoatSimulatorDatabase() {
        this.setBoats(new Repository<>());
        this.setEngines(new Repository<>());
    }

    public IRepository<Sailable> getBoats() {
        return this.boats;
    }

    private void setBoats(IRepository<Sailable> boats) {
        this.boats = boats;
    }

    public IRepository<BaseEngine> getEngines() {
        return this.engines;
    }

    private void setEngines(IRepository<BaseEngine> engines) {
        this.engines = engines;
    }
}
