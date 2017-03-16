package exercise.P08_Military_Elite.models;

import exercise.P08_Military_Elite.interfaces.iCommando;

import java.util.LinkedHashMap;

public class Commando extends SpecialisedSoldier implements iCommando {

    LinkedHashMap<String, Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missions = new LinkedHashMap<>();
    }

    @Override
    public void addMission(String codeName, Mission mission) {
        this.missions.put(codeName, mission);
    }

    @Override
    public void completeMission(String codeName) {
        this.missions.get(codeName).setState("Finished");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Missions:").append(System.lineSeparator());
        for (Mission mission : missions.values()) {
            sb.append("  ").append(mission).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
