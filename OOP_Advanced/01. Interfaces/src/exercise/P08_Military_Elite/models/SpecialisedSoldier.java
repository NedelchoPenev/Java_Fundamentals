package exercise.P08_Military_Elite.models;

import exercise.P08_Military_Elite.interfaces.iSpecialisedSoldier;

public abstract class SpecialisedSoldier extends Soldier implements iSpecialisedSoldier {

    private String corp;

    protected SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.setCorp(corp);
    }

    private String getCorp() {
        return corp;
    }

    private void setCorp(String corp) {
        if (!corp.equals(AIRFORCE) && !corp.equals(MARINE)){
            throw new IllegalArgumentException("invalid input");
        }
        this.corp = corp;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Corps: %s%n", this.corp);
    }
}
