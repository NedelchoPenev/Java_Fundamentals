package exercise.P08_Military_Elite.models;

import exercise.P08_Military_Elite.interfaces.iEngineer;

import java.util.LinkedList;

public class Engineer extends SpecialisedSoldier implements iEngineer {

    private LinkedList<Repaired> repairers;

    public Engineer(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairers = new LinkedList<>();
    }

    @Override
    public void addRepiredThing(Repaired repaired) {
        this.repairers.add(repaired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Repairs:").append(System.lineSeparator());
        for (Repaired repaired : repairers) {
            sb.append("  ").append(repaired).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
