package p06_Twitter.models;

import p06_Twitter.contracts.Client;
import p06_Twitter.contracts.Server;
import p06_Twitter.contracts.Tweet;

public class MicrowaveOven implements Client {

    private Server server;

    public MicrowaveOven(Server server) {
        this.server = server;
    }

    @Override
    public void receivesMessage(Tweet message) {
        System.out.println(message.retrieveMessage());
        sendToServer(message);
    }

    @Override
    public void sendToServer(Tweet message) {
        server.addMessage(message);
    }
}
