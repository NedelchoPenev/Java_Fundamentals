package p06_Twitter.models;

import p06_Twitter.contracts.Server;
import p06_Twitter.contracts.Tweet;

import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {

    List<Tweet> messagesStore;

    public ServerImpl() {
        this.messagesStore = new ArrayList<>();
    }

    @Override
    public void addMessage(Tweet message){
        this.messagesStore.add(message);
    }
}
