package lab.contracts;

import lab.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);

}
