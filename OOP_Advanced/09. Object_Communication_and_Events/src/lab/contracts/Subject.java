package lab.contracts;

public interface Subject {

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();

}
