package lab.controllers;

import lab.contracts.Handler;
import lab.enums.LogType;

public abstract class Logger implements Handler{

    private Handler successor;

    protected void passToSuccessor(LogType type, String message){
        if (this.successor != null){
            this.successor.handle(type, message);
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
