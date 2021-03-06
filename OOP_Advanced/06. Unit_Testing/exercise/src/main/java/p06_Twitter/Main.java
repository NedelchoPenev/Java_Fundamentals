package p06_Twitter;

import p06_Twitter.contracts.Client;
import p06_Twitter.contracts.Server;
import p06_Twitter.contracts.Tweet;
import p06_Twitter.models.Message;
import p06_Twitter.models.MicrowaveOven;
import p06_Twitter.models.ServerImpl;

public class Main {

    public static void main(String[] args) {
        Server server = new ServerImpl();
        Client client = new MicrowaveOven(server);
        Tweet tweet = new Message();
        client.receivesMessage(tweet);
    }
}

