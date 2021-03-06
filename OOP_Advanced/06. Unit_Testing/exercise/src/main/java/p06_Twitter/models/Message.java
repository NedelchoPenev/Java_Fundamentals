package p06_Twitter.models;

import p06_Twitter.contracts.Tweet;

import java.util.Random;

public class Message implements Tweet {

    @Override
    public String retrieveMessage() {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < random.nextInt(250); i++) {
            char ch = candidateChars.charAt(random.nextInt(candidateChars.length()));
            sb.append(ch);
        }
        sb.append(" ");

        return sb.toString();
    }
}
