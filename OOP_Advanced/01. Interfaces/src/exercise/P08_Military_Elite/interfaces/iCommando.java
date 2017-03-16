package exercise.P08_Military_Elite.interfaces;

import exercise.P08_Military_Elite.models.Mission;

public interface iCommando {

    void addMission(String codeName, Mission mission);
    void completeMission(String codeName);
}
