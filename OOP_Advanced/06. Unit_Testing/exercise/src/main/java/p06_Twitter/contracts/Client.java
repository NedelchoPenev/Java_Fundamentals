package p06_Twitter.contracts;

public interface Client {

    void receivesMessage(Tweet message);

    void sendToServer(Tweet message);
}
