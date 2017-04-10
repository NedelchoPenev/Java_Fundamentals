package exercise.p01_Logger.models;

import exercise.p01_Logger.contracts.File;

public class LogFile implements File {

    private StringBuilder stringBuilder;
    private int size;

    public LogFile() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void write(String message) {
        this.stringBuilder.append(message);
        this.increaseSize(message);
    }

    private void increaseSize(String message){
        int messageSize = 0;
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)){
                messageSize += ch;
            }
        }

        this.size += messageSize;
    }

    @Override
    public int getSize() {
        return this.size;
    }

}
