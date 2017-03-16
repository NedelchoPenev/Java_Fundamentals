package exercise.P08_Military_Elite.models;

import exercise.P08_Military_Elite.interfaces.iMission;

public class Mission implements iMission {

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    private String getCodeName() {
        return codeName;
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private String getState() {
        return state;
    }

    protected void setState(String state) {
        if (!state.equals(STATE_FINISHED) && !state.equals(STATE_IN_PROGRESS)) {
            throw new IllegalArgumentException("Invalid format");
        }
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
